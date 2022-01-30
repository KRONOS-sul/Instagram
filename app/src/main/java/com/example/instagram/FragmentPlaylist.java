package com.example.instagram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.databinding.FragmentPlaylistBinding;

import java.util.ArrayList;

public class FragmentPlaylist extends Fragment implements OnClick {

    private FragmentPlaylistBinding binding1;
    private ArrayList<Song> songs;
    private AdapterMusic adapterMusic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding1 = FragmentPlaylistBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding1.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapterMusic = new AdapterMusic(songs, this);
        binding1.recycler1.setAdapter(adapterMusic);
    }

    private void loadData() {
        songs = new ArrayList<>();
        songs.add(new Song("Godzilla", "Eminem feat. Juice WRLD", "3:31"));
        songs.add(new Song("Die a King", "lamjakehill", "2:49"));
        songs.add(new Song("HUMBLE", "Kendrick Lamar, Skrillex", "3:51"));
        songs.add(new Song("Harder Better Faster Stronger", "Kanye West", "2:20"));
        songs.add(new Song("Dies Irae","Apashe" , "5:10"));
        songs.add(new Song("Blood Water", "Grandson", "3:50"));
        songs.add(new Song("CLOUDS", "NF", "3:40"));
        songs.add(new Song("Bury the Light", "Casey Edwards", "9:18"));
        songs.add(new Song("Discord", "The Living Tombstone", "2:59"));
        songs.add(new Song("Look at me", "XXXtentacion", "2:06"));
        songs.add(new Song("Just Gold","MandoPony", "3:21"));
    }

    @Override
    public void onClick(Song song) {
        Bundle bundle =  new Bundle();
        Fragment fragment = new FragmentSongName();
        bundle.putString("KEY", song.getSongName() );
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.container_3, fragment).addToBackStack("1").commit();
    }
}