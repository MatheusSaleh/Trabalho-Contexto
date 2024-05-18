package br.edu.fema.dao;

import br.edu.fema.beans.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDao {

    private final Connection cnn;

    public AlbumDao(Connection cnn) {
        this.cnn = cnn;
    }

    public void criarTabela() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ALBUM (" +
                "cod INT PRIMARY KEY ," +
                "nome VARCHAR(50) NOT NULL," +
                "artista INT NOT NULL REFERENCES ARTISTA(CODIGO))";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.execute();
        ps.close();
        System.out.println("Tabela de Album criada com sucesso!");
    }

    public void cadastrar(Album p) throws SQLException{
        String sql = "INSERT INTO ALBUM VALUES (?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, p.getCodigo());
        ps.setString(2, p.getNome());
        ps.setInt(3, p.getArtista().getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Album cadastrado com sucesso!");
    }

    public void atualizar(Album p) throws SQLException{
        String sql = "UPDATE ALBUM SET nome = ?, artista = ? WHERE cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setInt(2, p.getArtista().getCodigo());
        ps.setInt(3, p.getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Album atualizado com sucesso!");
    }

    public void excluir(Album p) throws SQLException{
        String sql = "DELETE FROM ALBUM WHERE cod = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, p.getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Album excluído com sucesso!");
    }

    public ArrayList<Album> recuperarAlbuns() throws SQLException{
        AlbumDao albumDao = new AlbumDao(cnn);
        ArrayList<Album> resultado = new ArrayList<Album>();
        String sql = "SELECT * FROM ALBUM ORDER BY CODIGO";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Album a = new Album(0, null, null);
            a.setCodigo(rs.getInt("cod"));
            a.setNome(rs.getString("nome"));
            a.setArtista(new ArtistaDao(cnn).recuperarArtista(rs.getInt("artista")));
            resultado.add(a);
        }
        rs.close();
        ps.close();
        return resultado;
    }
}
