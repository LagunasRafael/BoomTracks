package com.example.boomtracks

import Playlist
import PlaylistAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {

    // Agregar las variables para los RecyclerViews
    private lateinit var genresRecyclerView: RecyclerView
    private lateinit var playlistsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        // Inicializar el RecyclerView de géneros
        genresRecyclerView = view.findViewById(R.id.genres_recycler_view)
        genresRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        genresRecyclerView.adapter = GenresAdapter(getGenresList())  // Asignamos el adaptador y la lista de géneros

        // Inicializar el RecyclerView de playlists
        playlistsRecyclerView = view.findViewById(R.id.playlists_recycler_view)
        playlistsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)  // Configura 2 columnas
        playlistsRecyclerView.adapter = PlaylistAdapter(getPlaylistsList())  // Asignamos el adaptador y la lista de playlists

        return view
    }

    // Método para generar la lista de géneros (puedes cambiarla por tus datos reales)
    private fun getGenresList(): List<String> {
        return listOf("Indie", "Blues", "Rock", "Trap", "Pop", "Jazz")
    }

    // Método para generar la lista de playlists
    private fun getPlaylistsList(): List<Playlist> {
        return listOf(
            Playlist("Indie Playlist", R.drawable.clairo),
            Playlist("Rock Classics", R.drawable.thedoors),
            Playlist("Trap Beats", R.drawable.travis),
            Playlist("Blues Essentials", R.drawable.john)
        )
    }
}
