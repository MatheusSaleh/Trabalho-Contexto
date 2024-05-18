package br.edu.fema.dao;

import br.edu.fema.beans.Musica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusicaDao {

    private final Connection cnn;

    public MusicaDao(Connection cnn) {
        this.cnn = cnn;
    }

    public void criarTabela() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS MUSICA (" +
                "cod INT PRIMARY KEY ," +
                "nome VARCHAR(50) NOT NULL," +
                "album INT NOT NULL REFERENCES ALBUM(COD))";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.execute();
        ps.close();
        System.out.println("Tabela de Musica criada com sucesso!");
    }

    public void cadastrar(Musica m) throws SQLException{
        String sql = "INSERT INTO MUSICA VALUES (?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, m.getCodigo());
        ps.setString(2, m.getNome());
        ps.setInt(3, m.getAlbum().getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Musica cadastrada com sucesso!");
    }

    public void atualizar(Musica m) throws SQLException{
        String sql = "UPDATE MUSICA SET nome = ?, album = ? WHERE cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, m.getNome());
        ps.setInt(2, m.getAlbum().getCodigo());
        ps.setInt(3, m.getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Musica atualizada com sucesso!");
    }

    public void excluir(Musica m) throws SQLException{
        String sql = "DELETE FROM MUSICA WHERE cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, m.getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Musica excluída com sucesso!");
    }

    public ArrayList<Musica> recuperarMusicas() throws SQLException{
        MusicaDao musicaDao = new MusicaDao(cnn);
        ArrayList<Musica> resultado = new ArrayList<Musica>();
        String sql = "SELECT * FROM MUSICA ORDER BY COD";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Musica m = new Musica(0, null, null);
            m.setCodigo(rs.getInt("cod"));
            m.setNome(rs.getString("nome"));
            m.setAlbum(new AlbumDao(cnn).recuperarAlbum(rs.getInt("album")));
            resultado.add(m);
        }
        rs.close();
        ps.close();
        return resultado;
    }

    public Musica recuperarMusica(Integer id) throws SQLException{
        Musica resultado = null;
        String sql = "SELECT * FROM MUSICA WHERE cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            resultado = new Musica(0, null, null);
            resultado.setCodigo(rs.getInt("cod"));
            resultado.setNome(rs.getString("nome"));
            resultado.setAlbum(new AlbumDao(cnn).recuperarAlbum(rs.getInt("album")));
        }
        rs.close();
        ps.close();
        return resultado;
    }
}
