<%-- 
    Document   : cadastro
    Created on : 29/03/2018, 00:03:25
    Author     : Anderson S Barros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controle.DatabaseConnection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Controle.CadastroFalhaException"%>

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
               
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                int codClient = databaseConnection.registerClient(nomeCli, telCli, emailCli);
                out.print("Cadastro Realizado com Sucesso!! <br><br>");
                
                out.print(
                    "Código Cliente: " + codClient + "<br>" +
                    "Nome: " + nomeCli + "<br>" +
                    "Telefone: " + telCli + "<br>" +
                    "E-mail: " + emailCli + "<br>"
                               );
            }catch(SQLException e) {
                out.println(e.getMessage());
            }catch(ClassNotFoundException e) {
                out.println(e.getMessage());
            }catch(CadastroFalhaException e) {
                out.println(e.getMessage());
            }  

            
        %>
        
    </body>
</html>
