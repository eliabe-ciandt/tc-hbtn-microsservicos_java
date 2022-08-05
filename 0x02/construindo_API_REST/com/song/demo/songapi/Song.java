package com.song.demo.songapi;

public class Song {

    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    public Song(Integer id, String nome, String artista, String album, String anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
    }

    public Song() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;

        Song song = (Song) o;

        if (getId() != null ? !getId().equals(song.getId()) : song.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(song.getNome()) : song.getNome() != null) return false;
        if (getArtista() != null ? !getArtista().equals(song.getArtista()) : song.getArtista() != null) return false;
        if (getAlbum() != null ? !getAlbum().equals(song.getAlbum()) : song.getAlbum() != null) return false;
        return getAnoLancamento() != null ? getAnoLancamento().equals(song.getAnoLancamento()) : song.getAnoLancamento() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getArtista() != null ? getArtista().hashCode() : 0);
        result = 31 * result + (getAlbum() != null ? getAlbum().hashCode() : 0);
        result = 31 * result + (getAnoLancamento() != null ? getAnoLancamento().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", artista='" + artista + '\'' +
                ", album='" + album + '\'' +
                ", anoLancamento='" + anoLancamento + '\'' +
                '}';
    }
}
