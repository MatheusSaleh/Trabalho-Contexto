package br.edu.fema.beans;

public class Artista {
    private Integer codigo;

    private String nome;

    private String gravadora;

    public Artista(Integer codigo, String nome, String gravadora) {
        this.codigo = codigo;
        this.nome = nome;
        this.gravadora = gravadora;
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

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
}
