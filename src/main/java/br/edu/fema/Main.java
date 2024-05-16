package br.edu.fema;

import br.edu.fema.uteis.GerenciadorConexao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection cnn = GerenciadorConexao.getConnection()){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}