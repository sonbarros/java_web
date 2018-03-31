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
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root"; 
    String senha = "";
    
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
    
    public int registerClient(String nome, String telefone, String email) throws SQLException, ClassNotFoundException, CadastroFalhaException {
       
            
            this.openConnection("faculdade");
            Statement stmt = conn.createStatement();
            Number num = stmt.executeUpdate("INSERT INTO cliente(nome, telefone, email) VALUES ('"+ nome +"', '"+ telefone +"', '"+ email + "')");
            stmt.close();
            
            int codCli = this.getCodClient(nome);
                    
            conn.close();
            
            if(!num.equals(1)) {
                throw new CadastroFalhaException(nome);
            }
            
            return codCli;
    }
    
    private int getCodClient(String nome) throws SQLException {
        
        String firstName;
        if(nome.indexOf(' ') == -1) {
            firstName = nome;
        }else {
            firstName = nome.substring(0, nome.indexOf(' '));
        }
        
        PreparedStatement pstmt = this.conn.prepareStatement("SELECT id FROM cliente WHERE nome LIKE '"+ firstName +"%' ORDER BY ID DESC LIMIT 1");
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        
        pstmt.close();
        rs.close();
        
        return id;
        
        /* para chamar esse metodo você deve considerar que a conexao com
           o banco deve estar aberta
        */    
    }
    
}