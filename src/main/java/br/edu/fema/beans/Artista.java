package br.edu.fema.beans;

import java.util.Objects;

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

    public String toString(){
        return "Codigo do artista: " + codigo + "\nNome do artista: " + nome + "\nGravadora: " + gravadora + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(codigo, artista.codigo) && Objects.equals(nome, artista.nome) && Objects.equals(gravadora, artista.gravadora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, gravadora);
    }
}
