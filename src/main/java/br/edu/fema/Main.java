package br.edu.fema;

import br.edu.fema.beans.Album;
import br.edu.fema.beans.Artista;
import br.edu.fema.beans.Musica;
import br.edu.fema.dao.AlbumDao;
import br.edu.fema.dao.ArtistaDao;
import br.edu.fema.dao.MusicaDao;
import br.edu.fema.uteis.GerenciadorConexao;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (Connection cnn = GerenciadorConexao.getConnection()){
            //dao.criarTabela();
            //dao.cadastrar(new Artista(1, "Raul Seixas", "CBS"));
            //dao.cadastrar(new Artista(2, "Legião Urbana", "EMI"));
            //dao.cadastrar(new Artista(3, "Cazuza", "Som Livre"));
            //albumDao.criarTabela();
            //albumDao.cadastrar(new Album(1, "Gita", new Artista(1, "Raul Seixas", "CBS")));
            //albumDao.cadastrar(new Album(2, "Que país é este?", new Artista(2, "Legião Urbana", "EMI")));
            //albumDao.cadastrar(new Album(3, "Exagerado", new Artista(3, "Cazuza", "Som Livre")));
//            musicaDao.criarTabela();
//            musicaDao.cadastrar(new Musica(1, "Trem das Sete", new Album(1, "Gita", new Artista(1, "Raul Seixas", "CBS"))));
//            musicaDao.cadastrar(new Musica(2, "Que país é este?", new Album(2, "Faroeste Caboclo", new Artista(2, "Legião Urbana", "EMI"))));
//            musicaDao.cadastrar(new Musica(3, "Exagerado", new Album(3, "Codinome Beija-Glor", new Artista(3, "Cazuza", "Som Livre"))));
            ArtistaDao dao = new ArtistaDao(cnn);
            AlbumDao albumDao = new AlbumDao(cnn);
            MusicaDao musicaDao = new MusicaDao(cnn);
            ArrayList<Artista> artistas = dao.recuperarArtistas();
            System.out.println("Lista de artistas:");
            for (Artista a : artistas) {
                System.out.println(a.getCodigo() + " - " + a.getNome() + " - " + a.getGravadora());
            }
            ArrayList<Album> albuns = albumDao.recuperarAlbuns();
            System.out.println("Lista de albuns:");
            for (Album a : albuns) {
                System.out.println(a.getCodigo() + " - " + a.getNome() + " - " + a.getArtista().getNome() + " - " + a.getArtista().getGravadora());
            }
            ArrayList<Musica> musicas = musicaDao.recuperarMusicas();
            System.out.println("Lista de musicas:");
            for(Musica m : musicas){
                System.out.println(m.getCodigo() + " - " + m.getNome() + " - " + m.getAlbum().getNome() + " - " + m.getAlbum().getArtista().getNome());
            }
            musicaDao.atualizar(new Musica(1, "Sociedade Alternativa", new Album(1, "Gita", new Artista(1, "Raul Seixas", "CBS"))));
            musicaDao.excluir(new Musica(2, "Que país é este?", new Album(2, "Faroeste Caboclo", new Artista(2, "Legião Urbana", "EMI"))));
            albumDao.atualizar(new Album(1, "Krig-Ha, Bandolo", new Artista(1, "Raul Seixas", "CBS")));
            albumDao.excluir(new Album(2, "Faroeste Caboclo", new Artista(2, "Legião Urbana", "EMI")));
            dao.atualizar(new Artista(1, "Raul Santos Seixas", "Warner"));
            dao.excluir(new Artista(2, "Legião Urbana", "EMI"));
            System.out.println("Testes dos métodos de recuperar");
            System.out.println(dao.recuperarArtista(1).getNome());
            System.out.println(albumDao.recuperarAlbum(1).getNome());
            System.out.println(musicaDao.recuperarMusica(1).getNome());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}