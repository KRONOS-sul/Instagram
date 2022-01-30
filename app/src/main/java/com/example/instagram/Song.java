package com.example.instagram;

public class Song {
    private String songName;
    private String artist;
    private String duration;

    public Song(String songName, String artist, String duration) {
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
