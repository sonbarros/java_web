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
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root"; 
    String senha = "1020";
    
    public Connection conectaMySql(String nameDB) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url+nameDB, usuario, senha);
        }catch(SQLException e) {
            System.out.println("Caminho, usuario ou senha invalido");
        }catch(ClassNotFoundException x) {
            System.out.println("Driver nãa encontrado");
        }
        return con;
    }   
}
