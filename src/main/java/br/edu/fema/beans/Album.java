package br.edu.fema.beans;

import java.util.Objects;

public class Album {
    private Integer codigo;

    private String nome;

    private Artista artista;

    public Album(Integer codigo, String nome, Artista artista) {
        this.codigo = codigo;
        this.nome = nome;
        this.artista = artista;
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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String toString(){
        return "Codigo do album: " + codigo + "\nNome do album: " + nome + "\nArtista: " + artista.getNome() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(codigo, album.codigo) && Objects.equals(nome, album.nome) && Objects.equals(artista, album.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, artista);
    }
}
