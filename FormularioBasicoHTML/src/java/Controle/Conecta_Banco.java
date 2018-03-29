package Controle;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Anderson
 */
public class Conecta_Banco {
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root"; 
    String senha = "1020";
    
    public Connection conectaMySql(String nameDB) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url+nameDB, usuario, senha);
            return conn;
        }catch(SQLException e) {
            
            throw new SQLException("Caminho, usuario ou senha invalido", e);
        }catch(ClassNotFoundException x) {
           
            throw new ClassNotFoundException("Driver nãa encontrado", x);
        }
        
    }   
}
