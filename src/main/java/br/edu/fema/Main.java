package br.edu.fema;

import br.edu.fema.beans.Album;
import br.edu.fema.beans.Artista;
import br.edu.fema.dao.AlbumDao;
import br.edu.fema.dao.ArtistaDao;
import br.edu.fema.uteis.GerenciadorConexao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (Connection cnn = GerenciadorConexao.getConnection()){
            Statement stmt = cnn.createStatement();

            ArtistaDao dao = new ArtistaDao(cnn);
            AlbumDao albumDao = new AlbumDao(cnn);
            albumDao.criarTabela();
            albumDao.cadastrar(new Album(1, "Gita", new Artista(1, "Raul Seixas", "CBS")));
            albumDao.cadastrar(new Album(2, "Que país é este?", new Artista(2, "Legião Urbana", "EMI")));
            albumDao.cadastrar(new Album(3, "Exagerado", new Artista(3, "Cazuza", "Som Livre")));
            //dao.criarTabela();
            //dao.cadastrar(new Artista(1, "Raul Seixas", "CBS"));
            //dao.cadastrar(new Artista(2, "Legião Urbana", "EMI"));
            //dao.cadastrar(new Artista(3, "Cazuza", "Som Livre"));
            ArrayList<Artista> artistas = dao.recuperarArtistas();
            for (Artista a : artistas) {
                System.out.println(a.getCodigo() + " - " + a.getNome() + " - " + a.getGravadora());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}