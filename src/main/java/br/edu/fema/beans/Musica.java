package br.edu.fema.beans;

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
}
