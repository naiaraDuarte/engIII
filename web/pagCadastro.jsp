<%@page import="br.com.fatecmc.esiii.cadastros.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <h1>Cadastrar Aluno</h1>
            Nome:<input type="text" name="nome"></br>
            Sobrenome:<input type="text" name="sobrenome"></br>
            Materia:<input type="text" name="materia"></br>
            <button type="submit" name="botao">Enviar</button>
        </form>
    </body>
</html>
<%
    request.setCharacterEncoding("UTF-8");
    String nome = request.getParameter("nome");
    String sobrenome = request.getParameter("sobrenome");
    String materia = request.getParameter("materia");

    Aluno aluno = new Aluno();
    aluno.setNome(nome);
    aluno.setSobrenome(sobrenome);
    aluno.setMateria(materia);
    aluno.salvar();
    
%>