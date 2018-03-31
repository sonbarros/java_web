package Controle;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anderson
 */
public class DatabaseConnection {
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root"; 
    String senha = "1020";
    
    private Connection openConnection(String nameDB) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url+nameDB, usuario, senha);
            return conn;
        }catch(SQLException e) {
            
            throw new SQLException(e.getMessage(), e);
        }catch(ClassNotFoundException x) {
           
            throw new ClassNotFoundException(x.getMessage(), x);
        }
        
    }
    
    public void registerClient(String nome, String telefone, String email) throws SQLException, ClassNotFoundException, CadastroFalhaException {
       
            
            this.openConnection("faculdade");
            Statement stmt = conn.createStatement();
            Number num = stmt.executeUpdate("INSERT INTO discipulos(nome, telefone, email) VALUES ('"+ nome +"', '"+ telefone +"', '"+ email + "')");
            stmt.close();
            if(!num.equals(1)) {
                throw new CadastroFalhaException(nome);
            }
            
       
    }
    
    
    
    
}
