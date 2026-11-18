package com.example.playlistmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appstate.transform.transform
import androidx.compose.remote.creation.compose.state.transform
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class TrackAdapter(private val tracks: List<Track>) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {
    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val trackImage: ImageView = itemView.findViewById(R.id.trackImage)
        val trackName: TextView = itemView.findViewById(R.id.trackName)
        val artistName: TextView = itemView.findViewById(R.id.artistName)
        val enterArtist: ImageView = itemView.findViewById(R.id.enterArtist)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_track,parent,false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = tracks[position]
        holder.trackName.text = track.trackName
        holder.artistName.text = "${track.artistName} • ${track.trackTime}"
        Glide.with(holder.itemView.context)
            .load(track.artworkUrl100)
            .placeholder(R.drawable.ic_placeholder)
            .centerInside()
            .transform(RoundedCorners(10))
            .into(holder.trackImage)

    }
    override fun getItemCount(): Int {
        return tracks.size
    }
}