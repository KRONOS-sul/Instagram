package com.example.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.databinding.ItemSongBinding;

import java.util.ArrayList;

public class AdapterMusic extends RecyclerView.Adapter<AdapterMusic.MyViewHolder> {

    private ArrayList<Song> songs = new ArrayList<>();
    private OnClick onClick;


    public AdapterMusic(ArrayList<Song> songs, OnClick onClick) {
        this.songs = songs;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemSongBinding binding = ItemSongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(songs.get(position));
        holder.itemView.setOnClickListener(view -> {
            onClick.onClick(songs.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemSongBinding binding;

        public MyViewHolder(@NonNull ItemSongBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(Song song) {
            binding.number.setText(String.valueOf(getAdapterPosition()+1));
            binding.songName.setText(song.getSongName());
            binding.artist.setText(song.getArtist());
            binding.duration.setText(song.getDuration());
        }
    }
}
