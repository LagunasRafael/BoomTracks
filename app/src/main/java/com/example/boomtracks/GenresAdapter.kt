package com.example.boomtracks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenresAdapter(private val genres: List<String>) : RecyclerView.Adapter<GenresAdapter.GenreViewHolder>() {

    // ViewHolder que almacena las vistas de cada item
    class GenreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val genreImageView: ImageView = view.findViewById(R.id.genre_image)
        val genreTextView: TextView = view.findViewById(R.id.genre_name)
    }

    // Inflamos el layout para cada item del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false)
        return GenreViewHolder(view)
    }

    // Asignamos los datos a cada item
    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genreName = genres[position]
        holder.genreTextView.text = genreName

        // Asignamos la imagen correspondiente dependiendo del género
        when (genreName) {
            "Indie" -> holder.genreImageView.setImageResource(R.drawable.indie)
            "Blues" -> holder.genreImageView.setImageResource(R.drawable.blues)
            "Rock" -> holder.genreImageView.setImageResource(R.drawable.rock)
            "Trap" -> holder.genreImageView.setImageResource(R.drawable.trap)
            "Pop" -> holder.genreImageView.setImageResource(R.drawable.pop)
            "Jazz" -> holder.genreImageView.setImageResource(R.drawable.jazz)
            else -> holder.genreImageView.setImageResource(R.drawable.indie)  // Imagen por defecto
        }
    }

    // Número de elementos en el RecyclerView
    override fun getItemCount(): Int = genres.size
}
