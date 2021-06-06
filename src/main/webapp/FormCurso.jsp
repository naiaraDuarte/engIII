<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <link href="./css/styleindex.css" rel="stylesheet" type="text/css" />
    <link href="./css/style.css" rel="stylesheet" type="text/css" />
    <title>GeAcad - Curso</title>
</head>

<%
    String nome =      request.getParameter("nome");
    String turno =     request.getParameter("turno");
    String descricao = request.getParameter("descricao");
    String duracao =   request.getParameter("duracao");
    String id =        request.getParameter("id");
    
    if(nome == null) nome = "";
    if(turno == null) turno = "";
    if(descricao == null) descricao = "";
    if(duracao == null) duracao = "";
    if(id == null) id = "";
%>

<body>
    <div id="menu">
        <ul>
            <li><a href="../index.html">Home</a></li>
            <li><a href="./ListAluno.xhtml">Aluno</a></li>
            <li><a href="./ListProfessor.xhtml">Professor</a></li>
            <li><a href="./ListCurso.xhtml">Curso</a></li>
            <li><a href="./ListTurma.xhtml">Turma</a></li>
            <li><a href="./ListDisciplina.xhtml">Disciplina</a></li>
        </ul>
    </div>
    <form action="./Curso" method="post">
    <fieldset>

        <fieldset class="grupo">
            <div class="campo">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" style="width: 20em" value="<%=nome%>">
            </div>
        </fieldset> 

        <div class="campo">
            <label for="turno">Turno</label>
            <input type="text" id="turno" name="turno" style="width: 20em" value="<%=turno%>">
        </div>

        <div class="campo">
            <label for="descricao">Descrição</label>
            <input type="text" id="descricao" name="descricao" style="width: 20em" value="<%=descricao%>">
        </div>

        <fieldset class="grupo">
            <div class="campo">
                <label for="duracao">Duração</label>
                <input type="text" id="duracao" name="duracao" style="width: 20em" value="<%=duracao%>">
            </div>
        </fieldset>
        
        <input type="hidden" id="id" name="id" value="<%=id%>">

        <button class="botao submit" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR" %>">Salvar</button>

    </fieldset>
    </form>
</body>
</html>