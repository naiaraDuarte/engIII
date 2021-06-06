<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <link href="./css/styleindex.css" rel="stylesheet" type="text/css" />
    <link href="./css/style.css" rel="stylesheet" type="text/css" />
    <title>GeAcad - Aluno</title>
</head>

<%
    String status =    request.getParameter("status");
    String ra =        request.getParameter("ra");
    String turma =     request.getParameter("turma");
    String pessoa =    request.getParameter("pessoa");
    String nome =      request.getParameter("nome");
    String email =     request.getParameter("email");
    String rg =        request.getParameter("rg");
    String cpf =       request.getParameter("cpf");
    String datanasc =  request.getParameter("datanasc");
    String sexo =      request.getParameter("sexo");
    String id =        request.getParameter("id");
    
    if(status == null) status = "";
    if(ra == null) ra = "";
    if(turma == null) turma = "";
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
    <form action="./Aluno" method="post">
    <fieldset>

        <fieldset class="grupo">
            <div class="campo">
                <label for="ra">RA</label>
                <input type="text" id="ra" name="ra" style="width: 20em" value="<%=ra%>">
            </div>
        </fieldset> 

        <div class="campo">
            <label for="status">Status</label>
            <input type="text" id="status" name="status" style="width: 41em" value="<%=status%>">
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
        
        <div class="campo">
            <label for="turma">Turma</label>
            <input type="text" id="turma" name="turma" style="width: 20em" value="<%=turma%>">
        </div>  
        
        <input type="hidden" id="pessoa" name="pessoa" value="<%=pessoa%>">
        <input type="hidden" id="id" name="id" value="<%=id%>">

        <button class="botao submit" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR" %>">Salvar</button>

    </fieldset>
    </form>
</body>
</html>