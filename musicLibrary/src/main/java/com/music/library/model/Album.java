package com.music.library.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Album {
    private int id;
    private String artist;
    private String album;
    private String year;
    private String spotify;
    private String description;
    private String wiki;
    private String duration;
    private int min;
    private int sec;

    public Album(int id, String artist, String album, String year, String spotify, String description, String wiki, String duration, int min, int sec) {
        this.id = id;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.spotify = spotify;
        this.description = description;
        this.wiki = wiki;
        this.duration = duration;
        this.min = min;
        this.sec = sec;
    }

    public Album(String artist, String album, String year, String spotify, String description, String wiki, String duration, int min, int sec) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.spotify = spotify;
        this.description = description;
        this.wiki = wiki;
        this.duration = duration;
        this.min = min;
        this.sec = sec;
    }

    @Override
    public String toString() {
        return String.format("artist:%-10s\nalbum:%-10s\nyear:%-10s\nspotify:%-10s\ndescription:%-10s\nwiki:%-10s\nduration:%-10s"
                , artist, album, year, spotify, description, wiki, duration);
    }
}
