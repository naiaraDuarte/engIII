<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <link href="./css/styleindex.css" rel="stylesheet" type="text/css" />
    <link href="./css/style.css" rel="stylesheet" type="text/css" />
    <title>GeAcad - Turma</title>
</head>

<%
    String descricao =  request.getParameter("descricao");
    String datainicio = request.getParameter("datainicio");
    String curso =      request.getParameter("curso");
    String id =         request.getParameter("id");
    
    if(descricao == null) descricao = "";
    if(datainicio == null) datainicio = "";
    if(curso == null) curso = "";
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
    <form action="./Turma" method="post">
    <fieldset>
                
        <fieldset class="grupo">
            <div class="campo">
                <label for="descricao">Descrição</label>
                <input type="text" id="descricao" name="descricao" style="width: 20em" value="<%=descricao%>">
            </div>
        </fieldset> 

        <div class="campo">
            <label for="datainicio">Data de Início</label>
            <input type="date" id="datainicio" name="datainicio" style="width: 20em" value="<%=datainicio%>">
        </div>

        <fieldset class="grupo">
            <div class="campo">
                <label for="datainicio">Curso</label>
                <input type="text" id="curso" name="curso" style="width: 20em" value="<%=curso%>">
            </div>
        </fieldset> 
        
        <input type="hidden" id="id" name="id" value="<%=id%>">

        <button class="botao submit" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR" %>">Salvar</button>

    </fieldset>
    </form>
</body>
</html>