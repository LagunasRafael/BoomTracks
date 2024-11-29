package com.example.boomtracks

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Vincular elementos de la vista
        val youtubeWebView: WebView = view.findViewById(R.id.youtube_webview_1)
        val youtubeWebView2: WebView = view.findViewById(R.id.youtube_webview_2)
        val youtubeWebView3: WebView = view.findViewById(R.id.youtube_webview_3)
        val btnLike: ImageButton = view.findViewById(R.id.btn_like_1)
        val btnComment: ImageButton = view.findViewById(R.id.btn_comment_1)
        val inputComment: EditText = view.findViewById(R.id.input_comment_1)
        val commentsList: TextView = view.findViewById(R.id.comments_list_1)
        val inputComment2: EditText = view.findViewById(R.id.input_comment_2)
        val commentsList2: TextView = view.findViewById(R.id.comments_list_2)
        val inputComment3: EditText = view.findViewById(R.id.input_comment_3)
        val commentsList3: TextView = view.findViewById(R.id.comments_list_3)
        val btnAgregar: Button= view.findViewById(R.id.btnAgregar)


        // Configurar el WebView
        youtubeWebView.webViewClient = WebViewClient()
        val webSettings: WebSettings = youtubeWebView.settings
        webSettings.javaScriptEnabled = true


        // Configurar el WebView
        youtubeWebView2.webViewClient = WebViewClient()
        val webSettings2: WebSettings = youtubeWebView2.settings
        webSettings2.javaScriptEnabled = true

        // Configurar el WebView
        youtubeWebView3.webViewClient = WebViewClient()
        val webSettings3: WebSettings = youtubeWebView3.settings
        webSettings3.javaScriptEnabled = true



        // Cargar un video de YouTube
        val videoUrl = "https://www.youtube.com/embed/V9PVRfjEBTI" // URL del video
        youtubeWebView.loadUrl(videoUrl)

        // Cargar un video de YouTube
        val videoUrl2 = "https://www.youtube.com/embed/Mx92lTYxrJQ" // URL del video
        youtubeWebView2.loadUrl(videoUrl2)

        // Cargar un video de YouTube
        val videoUrl3 = "https://www.youtube.com/embed/kPa7bsKwL" // URL del video
        youtubeWebView3.loadUrl(videoUrl3)

        // Configurar acciones de los botones
        btnLike.setOnClickListener {
            // Lógica para el botón "Me gusta"
            println("Like presionado")
        }



        btnAgregar.setOnClickListener {
            // Iniciar una nueva transacción para cambiar de fragmento
            val transaction = requireActivity().supportFragmentManager.beginTransaction()

            // Crear una instancia del fragmento de destino (CrearProyectoFragment)
            val fragment = CrearProyectoFragment()

            // Agregar el fragmento al contenedor
            transaction.replace(R.id.fragment_container, fragment)

            // Confirmar la transacción
            transaction.addToBackStack(null) // Esto permite que el fragmento se pueda volver atrás
            transaction.commit()
        }


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
