package br.edu.fema.beans;

import java.util.Objects;

public class Musica {
    private Integer codigo;

    private String nome;

    private Album album;

    public Musica(Integer codigo, String nome, Album album) {
        this.codigo = codigo;
        this.nome = nome;
        this.album = album;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String toString(){
        return "Codigo da musica: " + codigo + "\nNome da musica: " + nome + "\nAlbum: " + album.getNome() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return Objects.equals(codigo, musica.codigo) && Objects.equals(nome, musica.nome) && Objects.equals(album, musica.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, album);
    }
}
