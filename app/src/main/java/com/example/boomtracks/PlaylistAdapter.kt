import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.boomtracks.R

class PlaylistAdapter(private val playlists: List<Playlist>) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    // ViewHolder que almacena las vistas de cada item
    class PlaylistViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playlistImageView: ImageView = view.findViewById(R.id.playlist_image)
        val playlistNameTextView: TextView = view.findViewById(R.id.playlist_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.playlistNameTextView.text = playlist.name
        holder.playlistImageView.setImageResource(playlist.imageRes)
    }

    override fun getItemCount(): Int = playlists.size
}
