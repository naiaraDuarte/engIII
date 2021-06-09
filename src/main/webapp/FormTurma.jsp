<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
    String nome = request.getParameter("nome");
    String ano = request.getParameter("ano");
    String periodo = request.getParameter("periodo");
    String id = request.getParameter("id");

    if (nome == null) {
        nome = "";
    }
    if (ano == null) {
        ano = "";
    }
    if (periodo == null) {
        periodo = "";
    }
    if (id == null)
        id = "";
%>
<div class="conteudo">
    <div class="titulo">
        <h3> <i class="fas fa-angle-right"></i> Turma</h3>
    </div>
    <hr/>
<form action="./Turma" method="post">
    <div class="form-row">

        
            <div class="form-group col-md-6">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" style="width: 20em" value="<%=nome%>">
            </div>
        
        
        <div class="form-group col-md-6">
            <label for="ano">Ano letivo</label>
            <input type="text" id="ano" name="ano" style="width: 20em" value="<%=ano%>">
        </div>

        <div class="form-group col-md-6">
                <label for="periodo">Periodo</label>
                <input type="text" id="periodo" name="periodo" style="width: 20em" value="<%=periodo%>">
        </div>
        

        <div class="form-row botao">
            <button class="btn btn-primary" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR"%>">Salvar</button>
        </div>
    </div>
</form>
<%@include file="footer.jsp" %>