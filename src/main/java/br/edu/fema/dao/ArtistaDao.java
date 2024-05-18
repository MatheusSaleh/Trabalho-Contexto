package br.edu.fema.dao;

import br.edu.fema.beans.Artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistaDao {

    private final Connection cnn;

    public ArtistaDao(Connection cnn) {
        this.cnn = cnn;
    }

    public void criarTabela() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ARTISTA (" +
                "cod INT PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL," +
                "gravadora VARCHAR(50) NOT NULL)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.execute();
        ps.close();
        System.out.println("Tabela de Artista criada com sucesso!");
    }

    public void cadastrar(Artista p) throws SQLException{
        String sql = "INSERT INTO ARTISTA VALUES (?,?,?)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, p.getCodigo());
        ps.setString(2, p.getNome());
        ps.setString(3, p.getGravadora());
        ps.execute();
        ps.close();
        System.out.println("Artista cadastrado com sucesso!");
    }

    public void atualizar(Artista p) throws SQLException{
        String sql = "UPDATE ARTISTA SET nome = ?, gravadora = ? WHERE codigo = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getGravadora());
        ps.setInt(3, p.getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Artista atualizado com sucesso!");
    }

    public void excluir(Artista p) throws SQLException{
        String sql = "DELETE FROM ARTISTA WHERE codigo = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, p.getCodigo());
        ps.execute();
        ps.close();
        System.out.println("Artista excluído com sucesso!");
    }

    public ArrayList<Artista> recuperarArtistas() throws SQLException{
        ArtistaDao daoArtista = new ArtistaDao(cnn);
        ArrayList<Artista> resultado = new ArrayList<Artista>();
        String sql = "SELECT * FROM ARTISTA ORDER BY CODIGO";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Artista artista = new Artista(0, null, null);
            artista.setCodigo(rs.getInt("CODIGO"));
            artista.setNome(rs.getString("NOME"));
            artista.setGravadora(rs.getString("GRAVADORA"));
            resultado.add(artista);
        }
        rs.close();
        ps.close();
        return resultado;
    }

    public Artista recuperarArtista(Integer id) throws SQLException{
        Artista resultado = null;
        String sql = "SELECT * FROM ARTISTA WHERE CODIGO = ?";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            resultado = new Artista(0, null, null);
            resultado.setCodigo(rs.getInt("CODIGO"));
            resultado.setNome(rs.getString("NOME"));
            resultado.setGravadora(rs.getString("GRAVADORA"));
        }
        rs.close();
        ps.close();
        return resultado;
    }
}
