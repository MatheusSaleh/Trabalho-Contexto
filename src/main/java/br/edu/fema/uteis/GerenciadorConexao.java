package br.edu.fema.uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {

    private static Connection cnn;

    private GerenciadorConexao() {
    }

    public static Connection getConnection()
        throws ClassNotFoundException, SQLException{
        if(cnn == null){
            Class.forName(Constantes.DRIVE);
            cnn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.PASSWORD);
        }
        return cnn;
    }
}
