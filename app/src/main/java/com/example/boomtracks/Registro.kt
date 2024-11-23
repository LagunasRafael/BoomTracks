package com.example.boomtracks

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {

    private lateinit var nombre: TextInputLayout
    private lateinit var confirmar: TextInputLayout
    private lateinit var correo: TextInputLayout
    private lateinit var contrasena: TextInputLayout

    private lateinit var btnestoyregistrado: MaterialButton
    private lateinit var btnregistrarse: Button
    private lateinit var cbCliente: CheckBox
    private lateinit var cbAdmin: CheckBox

    private var perfil_cliente: Boolean = false
    private var perfil_admin: Boolean = false

    private lateinit var usuario: Usuario

    private lateinit var auth: FirebaseAuth

    //inicializar coleccion de usuarios en firebase
    private var coleccionUsuarios = Firebase.firestore.collection("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cbCliente = findViewById(R.id.cbCliente_registro)
        cbAdmin = findViewById(R.id.cbAdmin_registro)

        btnestoyregistrado = findViewById(R.id.btnEstoyregistrado)
        btnregistrarse = findViewById(R.id.btnRegistrarse)

        auth = FirebaseAuth.getInstance()

        nombre = findViewById(R.id.txtNombreUsuario)
        confirmar = findViewById(R.id.txtConfirmar)
        correo = findViewById(R.id.txtCorreo)
        contrasena = findViewById(R.id.txtContrasena)

        btnestoyregistrado.setOnClickListener {
            finish()

        }

        btnregistrarse.setOnClickListener {
            usuario = Usuario(
                correo.editText?.text.toString(),
                nombre.editText?.text.toString(),
                confirmar.editText?.text.toString(),
                contrasena.editText?.text.toString(),
                perfil_cliente,
                perfil_admin
            )
            confirmarUsuario(usuario, contrasena.editText?.text.toString())
        }
    }

    private fun confirmarUsuario(user: Usuario, pass: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmar Usuario")
        builder.setMessage("""
            Nombre: ${user.nombre}
            Apellido Paterno: ${user.nombre}
            Apellido Materno: ${user.amaterno}
            Correo: ${user.correo}
            Contraseña: ${pass}
            Perfil de cliente: ${user.perfil_cliente}
            Perfil de administrador: ${user.perfil_admin}
        """.trimIndent())
        //boton cancelar y confirmar

        builder.setPositiveButton("confirmar", {dialog, which ->
            auth.createUserWithEmailAndPassword(user.correo.toString(),
                contrasena.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Usuario registrado",
                            Toast.LENGTH_SHORT).show()

                        //crear una coleccion de usuarios en firebase
                        val intent = Intent(this, Login::class.java).apply {
                            coleccionUsuarios
                                .document(user.correo.toString())
                                .set(user)
                        }

                        startActivity(intent)

                    }else{
                        Toast.makeText(this, "Error al registrar usuario",
                            Toast.LENGTH_SHORT).show()
                    }

                }
        })





        //boton cancelar y confirmar
        builder.setNegativeButton("Cancelar", null)
        val dialogo: AlertDialog = builder.create()
        dialogo.show()
    }

    fun onCheckBoxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when(view.id){
                R.id.cbCliente_registro -> {
                    perfil_cliente = checked
                    perfil_admin = false
                    cbAdmin.isChecked = false

                }

                R.id.cbProductor_registro -> {
                    perfil_cliente = checked
                    perfil_admin = false
                    cbAdmin.isChecked = false

                }

                R.id.cbAdmin_registro -> {
                    perfil_admin = checked
                    perfil_cliente = false
                    cbCliente.isChecked = false

                }
            }
        }
    }

}