<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <link href="./css/styleindex.css" rel="stylesheet" type="text/css" />
    <link href="./css/style.css" rel="stylesheet" type="text/css" />
    <title>GeAcad - Professor</title>
</head>

<%
    String salario =   request.getParameter("salario");
    String titulacao = request.getParameter("titulacao");
    String pessoa =    request.getParameter("pessoa");
    String nome =      request.getParameter("nome");
    String email =     request.getParameter("email");
    String rg =        request.getParameter("rg");
    String cpf =       request.getParameter("cpf");
    String datanasc =  request.getParameter("datanasc");
    String sexo =      request.getParameter("sexo");
    String id =        request.getParameter("id");
    
    if(salario == null) salario = "";
    if(titulacao == null) titulacao = "";
    if(pessoa == null) pessoa = "";
    if(nome == null) nome = "";
    if(email == null) email = "";
    if(rg == null) rg = "";
    if(cpf == null) cpf = "";
    if(datanasc == null) datanasc = "";
    if(sexo == null) sexo = "";
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
    <form action="./Professor" method="post">
    <fieldset>

        <fieldset class="grupo">
            <div class="campo">
                <label for="titulacao">Titulação</label>
                <input type="text" id="titulacao" name="titulacao" style="width: 20em" value="<%=titulacao%>">
            </div>
        </fieldset> 

        <div class="campo">
            <label for="salario">Salário</label>
            <input type="text" id="salario" name="salario" style="width: 20em" value="<%=salario%>">
        </div>

        <fieldset class="grupo">
            <div class="campo">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" style="width: 20em" value="<%=nome%>">
            </div>
        </fieldset> 

        <div class="campo">
            <label for="email">E-mail</label>
            <input type="text" id="email" name="email" style="width: 41em" value="<%=email%>">
        </div>

        <div class="campo">
            <label for="rg">RG</label>
            <input type="text" id="rg" name="rg" style="width: 20em" value="<%=rg%>">
        </div>

        <fieldset class="grupo">
            <div class="campo">
                <label for="cpf">CPF</label>
                <input type="text" id="cpf" name="cpf" style="width: 20em" value="<%=cpf%>">
            </div>
        </fieldset>

        <div class="campo">
            <label for="sexo">Sexo</label>
            <input type="text" id="sexo" name="sexo" style="width: 20em" value="<%=sexo%>">
        </div>

        <div class="campo">
            <label for="datanasc">Data de Nascimento</label>
            <input type="date" id="datanasc" name="datanasc" style="width: 20em" value="<%=datanasc%>">
        </div>
        
        <input type="hidden" id="pessoa" name="pessoa" value="<%=pessoa%>">
        <input type="hidden" id="id" name="id" value="<%=id%>">

        <button class="botao submit" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR" %>">Salvar</button>

    </fieldset>
    </form>
</body>
</html>