package com.example.boomtracks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

class Login : AppCompatActivity() {

    private lateinit var correo: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var btnIngresar: Button
    private lateinit var btnNoEstoyRegistrado: MaterialButton
    private lateinit var btnMenus: Button

    private lateinit var auth: FirebaseAuth

    //inicializar Coleccion
    val coleccion = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //inicializar autenticacion
        auth = FirebaseAuth.getInstance()
//        correo = findViewById(R.id.txtCorreo)
        password = findViewById(R.id.txtContrasena)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnNoEstoyRegistrado = findViewById(R.id.btnNoRegistrado)

        val emailInput = findViewById<EditText>(R.id.emailInput) // EditText para el correo
        val btnIngresar = findViewById<Button>(R.id.btnIngresar) // Botón para iniciar sesión


        btnIngresar.setOnClickListener {
            val correo = emailInput.text.toString().trim()

            // Validar el correo y redirigir
            val tipoUsuario = redirigirUsuario(correo)

            when (tipoUsuario) {
                "admin" -> {
                    // Redirigir a la pantalla de administradores
                    val intent = Intent(this, Admin_Principal::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Bienvenido, Administrador", Toast.LENGTH_SHORT).show()
                }
                "cliente" -> {
                    // Redirigir a la pantalla de clientes
                    val intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Bienvenido, Cliente", Toast.LENGTH_SHORT).show()
                }
                "error" -> {
                    // Mostrar error si el correo no pertenece a ninguna lista
                    Toast.makeText(this, "Correo no reconocido. Por favor, verifica tus credenciales.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnNoEstoyRegistrado.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }

    private fun redirigirUsuario(correo: String): String {
        val correosAdmin = listOf("rafa@gmail.com", "baca@gmail.com")
        val correosUsuarios = listOf("juan@gmail.com", "diego@gmail.com")

        return when {
            correo in correosAdmin -> "admin"
            correo in correosUsuarios -> "cliente"
            else -> "error" // Indica que el correo no pertenece a ninguna lista
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialogo: AlertDialog = builder.create()
        dialogo.show()
    }
}