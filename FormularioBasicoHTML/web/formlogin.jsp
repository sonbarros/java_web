<%-- 
    Document   : formlogin
    Created on : 29/03/2018, 00:03:25
    Author     : Anderson
--%>

<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="Controle.Conecta_Banco"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            Conecta_Banco conecta_Banco = new Conecta_Banco();
            Connection conn = conecta_Banco.conectaMySql("biblia");
            
            if(conn != null) {
                out.println("Conectado");
            }else {
                out.println("Não Conectado");
            }
            
            Statement stmt = conn.createStatement();
            Number num = stmt.executeUpdate("INSERT INTO discipulos(nome) VALUES ('MATHEUS')");
            stmt.close();
            out.println(num);
            
            conn.close();
            
        %>
        <h1>Informe login e senha</h1>
        <form action="formlogin.jsp">
            <label for="nome">Nome:</label>
            <input id="nome" name="user" type="text" size="15" maxlength="15"	 />

            <label for="senha">Senhas:</label>
            <input id="senha" name="pass" type="password" size="15" maxlength="10" />
            
            <input type="submit" value="enviar" />
        </form>
    </body>
</html>
