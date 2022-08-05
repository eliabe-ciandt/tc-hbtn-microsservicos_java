package com.song.demo.songapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api-song")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return ResponseEntity.ok().body("Olá, estranho").getBody();
    }

    @GetMapping("/allSongs")
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @GetMapping("/findSong/{id}")
    public Song findSongById(@PathVariable Integer id) {
        return songRepository.getSongById(id);
    }

    @PostMapping("/addSong")
    public void addSong(@RequestBody Song som) {
        songRepository.addSong(som);
    }

    @PutMapping("updateSong")
    public void updadeSong(@RequestBody Song song) {
        songRepository.updateSong(song);
    }

    @DeleteMapping("/removeSong")
    public void deleteSongById(@RequestBody Song song) {
        songRepository.removeSong(song);
    }


}
