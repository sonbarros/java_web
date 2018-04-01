package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Anderson S Barros
 * @e-mail anderson21br@gmail.com
 */
public class DatabaseConnection {
    
    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root"; 
    String senha = "";
    
    private Connection openConnection(String nameDB) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url+nameDB, usuario, senha);
            return conn;
        }catch(SQLException e) {
            
            throw new SQLException(e.getMessage(), e);
        }catch(ClassNotFoundException x) {
           
            throw new ClassNotFoundException(x.getMessage(), x);
        }
        
    }
    
    public int registerClient(String nome, String telefone, String email) throws SQLException, ClassNotFoundException, CadastroFalhaException {
        
            Connection conn = this.openConnection("faculdade");
            Statement stmt = conn.createStatement();
            Number num = stmt.executeUpdate("INSERT INTO cliente(nome, telefone, email) VALUES ('"+ nome +"', '"+ telefone +"', '"+ email + "')");
            stmt.close();     
            conn.close();
            
            if(!num.equals(1)) {
                throw new CadastroFalhaException(nome);
            }
            
            return this.getCodClient(nome);
    }
    
    private int getCodClient(String nome) throws SQLException, ClassNotFoundException {
        
        String firstName;
        /* Esse if: para separar o primeiro nome do ultimo nome,
         * caso tenhamos String nomes sem espaços, posso considerar que
         * foi informado apenas o primeiro nome.
         * O select pegará o ultimo id para o primeiro nome
         */
        if(nome.indexOf(' ') == -1) {
            firstName = nome;
        }else {
            firstName = nome.substring(0, nome.indexOf(' '));
        }
        
        Connection conn = this.openConnection("faculdade");
        PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM cliente WHERE nome LIKE '"+ firstName +"%' ORDER BY ID DESC LIMIT 1");
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        
        pstmt.close();
        rs.close();
        conn.close();
        
        return id;   
    }
    
}