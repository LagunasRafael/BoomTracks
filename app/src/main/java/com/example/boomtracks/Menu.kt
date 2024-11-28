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

        // Configurar el WebView
        val youtubeWebView: WebView = findViewById(R.id.youtube_webview)
        youtubeWebView.webViewClient = WebViewClient() // Para abrir en la app, no en el navegador.
        val webSettings: WebSettings = youtubeWebView.settings
        webSettings.javaScriptEnabled = true // Habilitar JavaScript para reproducir el video.

        // Configurar el WebView2
        val youtubeWebView2: WebView = findViewById(R.id.youtube_webview2)
        youtubeWebView2.webViewClient = WebViewClient() // Para abrir en la app, no en el navegador.
        val webSettings2: WebSettings = youtubeWebView2.settings
        webSettings2.javaScriptEnabled = true // Habilitar JavaScript para reproducir el video.

        // Configurar el WebView3
        val youtubeWebView3: WebView = findViewById(R.id.youtube_webview3)
        youtubeWebView3.webViewClient = WebViewClient() // Para abrir en la app, no en el navegador.
        val webSettings3: WebSettings = youtubeWebView3.settings
        webSettings3.javaScriptEnabled = true // Habilitar JavaScript para reproducir el video.

        val btnLike: ImageButton = findViewById(R.id.btn_like)
        val btnComment: ImageButton = findViewById(R.id.btn_comment)
        val inputComment: EditText = findViewById(R.id.input_comment)
        val commentsList: TextView = findViewById(R.id.comments_list)

        val btnLike2: ImageButton = findViewById(R.id.btn_like2)
        val btnComment2: ImageButton = findViewById(R.id.btn_comment2)
        val inputComment2: EditText = findViewById(R.id.input_comments)
        val commentsList2: TextView = findViewById(R.id.comments_list2)

        val btnLike3: ImageButton = findViewById(R.id.btn_like3)
        val btnComment3: ImageButton = findViewById(R.id.btn_comment3)
        val inputComment3: EditText = findViewById(R.id.input_comments3)
        val commentsList3: TextView = findViewById(R.id.comments_list3)





        // Configura el listener para manejar las selecciones de los elementos
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    // Acción para "Inicio"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()
                    true

                    // Acción para "Inicio"
                    val intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                    true

                }

                R.id.menu_perfil -> {
                    // Acción para "perfil"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SearchFragment())
                        .commit()
                    true

                    // Acción para "Perfil"
                    val intent = Intent(this, Ecoweb::class.java)
                    startActivity(intent)
                    true

                }

                R.id.menu_explorar -> {
                    // Acción para "explorar"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment())
                        .commit()
                    true


                    // Acción para "Explorar"
                    val intent = Intent(this, Explorar::class.java)
                    startActivity(intent)
                    true

                }

                else -> false
            }
        }








        btnLike.setOnClickListener {
            // Agregar lógica de "Me gusta"
            // Ejemplo: Mostrar un mensaje o cambiar el ícono
        }


        // Cargar el video de YouTube Billie Eilish
        val videoUrl =
            "https://www.youtube.com/embed/V9PVRfjEBTI" // Reemplaza con tu ID de video.
        youtubeWebView.loadUrl(videoUrl)

        // Cargar el video de YouTube Stephen Sanchez
        val videoUrl2 =
            "https://www.youtube.com/embed/Giz8aiJhENA" // Reemplaza con tu ID de video.
        youtubeWebView2.loadUrl(videoUrl2)

        // Cargar el video de YouTube
        val videoUrl3 =
            "https://www.youtube.com/embed/kPa7bsKwL" // Reemplaza con tu ID de video.
        youtubeWebView3.loadUrl(videoUrl3)



        btnComment.setOnClickListener {
            val comment = inputComment.text.toString()
            if (comment.isNotBlank()) {
                val currentComments = commentsList.text.toString()
                commentsList.text = "$currentComments\n- $comment"
                inputComment.text.clear()
            }



        }
    }
}