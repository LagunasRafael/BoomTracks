package com.example.boomtracks

import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class Menu : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        // Vincula el BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        // Cargar el fragmento inicial
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }


        // Configura el listener para manejar las selecciones de los elementos
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
//                    // Acción para "Inicio"
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, HomeFragment())
//                        .commit()
                    replaceFragment(HomeFragment())
                    true


                }

                R.id.menu_perfil -> {
//                    // Acción para "perfil"
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, SearchFragment())
//                        .commit()
                    replaceFragment(ProfileFragment())
                    true
                }

                R.id.menu_explorar -> {
//                    // Acción para "explorar"
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, ProfileFragment())
//                        .commit()

                    replaceFragment(SearchFragment())
                    true
                }

                R.id.menu_Contacto -> {
//                    // Acción para "explorar"
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, ProfileFragment())
//                        .commit()

                    replaceFragment(ContactoFragment())
                    true
                }

                R.id.menu_Nosotros -> {
//                    // Acción para "explorar"
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, ProfileFragment())
//                        .commit()

                    replaceFragment(NosotrosFragment())
                    true
                }

                else -> false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}