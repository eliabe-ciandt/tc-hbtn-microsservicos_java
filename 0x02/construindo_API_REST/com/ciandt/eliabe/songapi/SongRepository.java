package com.ciandt.eliabe.songapi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {

        Song som = null;

        for(Song song : list) {
            if (song.getId() == id) som = song;
        }

        return som;

    }

    public void addSong(Song song) {
        list.add(song);
    }

    public void updateSong(Song som) {

        Integer index = list.stream().filter(f -> f.getId() == som.getId()).map(list::indexOf).findAny().get();

        list.set(index, som);

    }

    public void removeSong(Song som) {
        list.remove(som);
    }

}
