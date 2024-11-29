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
        val youtubeWebView: WebView = view.findViewById(R.id.youtube_webview)
        val btnLike: ImageButton = view.findViewById(R.id.btn_like)
        val btnComment: ImageButton = view.findViewById(R.id.btn_comment)
        val inputComment: EditText = view.findViewById(R.id.input_comment)
        val commentsList: TextView = view.findViewById(R.id.comments_list)
        val btnAgregar: Button= view.findViewById(R.id.btnAgregar)


        // Configurar el WebView
        youtubeWebView.webViewClient = WebViewClient()
        val webSettings: WebSettings = youtubeWebView.settings
        webSettings.javaScriptEnabled = true

        // Cargar un video de YouTube
        val videoUrl = "https://www.youtube.com/embed/V9PVRfjEBTI" // URL del video
        youtubeWebView.loadUrl(videoUrl)

        // Configurar acciones de los botones
        btnLike.setOnClickListener {
            // Lógica para el botón "Me gusta"
            println("Like presionado")
        }

        btnAgregar.setOnClickListener{
            val intent = Intent(requireActivity(), Menu::class.java)
            startActivity(intent)
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
