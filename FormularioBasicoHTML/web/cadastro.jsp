<%-- 
    Document   : formlogin
    Created on : 29/03/2018, 00:03:25
    Author     : Anderson S Barros
--%>

<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="Controle.Conecta_Banco"%>

<%@page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%  
            String nomeCli = request.getParameter("nome");
            String telCli = request.getParameter("telefone");
            String emailCli = request.getParameter("email");
            //out.println("<h6>"+nomeCli+"</h6>");
            
            try {
                Conecta_Banco conecta_Banco = new Conecta_Banco();
                Connection conn = conecta_Banco.conectaMySql("faculdade");
                Statement stmt = conn.createStatement();
                Number num = stmt.executeUpdate("INSERT INTO discipulos(nome) VALUES ('MATHEUS')");
                stmt.close();
                out.println(num);
            
                conn.close();
                
            }catch(SQLException e) {
                out.println(e.getMessage());
            }catch(ClassNotFoundException e) {
                out.println(e.getMessage());
            }   

            
        %>
        <h1>Pagina JSP</h1>
        
    </body>
</html>
