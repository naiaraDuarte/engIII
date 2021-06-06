<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <link href="./css/styleindex.css" rel="stylesheet" type="text/css" />
    <link href="./css/style.css" rel="stylesheet" type="text/css" />
    <title>GeAcad - Disciplina</title>
</head>

<%
    String nome =      request.getParameter("nome");
    String cargahor =  request.getParameter("cargahor");
    String ementa =    request.getParameter("ementa");
    String objetivo =  request.getParameter("objetivo");
    String bibliog =   request.getParameter("bibliog");
    String semestre =  request.getParameter("semestre");
    String curso =     request.getParameter("curso");
    String professor = request.getParameter("professor");
    String id =        request.getParameter("id");
    
    if(nome == null) nome = "";
    if(cargahor == null) cargahor = "";
    if(ementa == null) ementa = "";
    if(objetivo == null) objetivo = "";
    if(bibliog == null) bibliog = "";
    if(semestre == null) semestre = "";
    if(curso == null) curso = "";
    if(professor == null) professor = "";
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
    <form action="./Disciplina" method="post">
    <fieldset>

        <fieldset class="grupo">
            <div class="campo">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" style="width: 20em" value="<%=nome%>">
            </div>
        </fieldset> 

        <div class="campo">
            <label for="cargah">Carga Horária</label>
            <input type="text" id="cargah" name="cargah" style="width: 20em" value="<%=cargahor%>">
        </div>

        <div class="campo">
            <label for="ementa">Ementa</label>
            <input type="text" id="ementa" name="ementa" style="width: 20em" value="<%=ementa%>">
        </div>

        <fieldset class="grupo">
            <div class="campo">
                <label for="objetivo">Objetivo</label>
                <input type="text" id="objetivo" name="objetivo" style="width: 40em" value="<%=objetivo%>">
            </div>
        </fieldset>

        <div class="campo">
            <label for="bibliog">Bibliografia</label>
            <input type="text" id="bibliog" name="bibliog" style="width: 20em" value="<%=bibliog%>">
        </div>

        <div class="campo">
            <label for="semestre">Semestre Recomendado</label>
            <input type="text" id="semestre" name="semestre" style="width: 20em" value="<%=semestre%>">
        </div>  

        <div class="campo">
            <label for="curso">Curso</label>
            <input type="text" id="curso" name="curso" style="width: 20em" value="<%=curso%>">
        </div>  

        <div class="campo">
            <label for="professor">Professor</label>
            <input type="text" id="professor" name="professor" style="width: 20em" value="<%=professor%>">
        </div>  
        
        <input type="hidden" id="id" name="v" value="<%=id%>">

        <button class="botao submit" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR" %>">Salvar</button>

    </fieldset>
    </form>
</body>
</html>