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

<form action="./Turma" method="post">
    <fieldset>

        <fieldset class="grupo">
            <div class="campo">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" style="width: 20em" value="<%=nome%>">
            </div>
        </fieldset> 

        <div class="campo">
            <label for="ano">Ano letivo</label>
            <input type="string" id="ano" name="ano" style="width: 20em" value="<%=ano%>">
        </div>

        <fieldset class="grupo">
            <div class="campo">
                <label for="periodo">Curso</label>
                <input type="text" id="periodo" name="periodo" style="width: 20em" value="<%=periodo%>">
            </div>
        </fieldset> 

        <input type="hidden" id="id" name="id" value="<%=id%>">

        <button class="botao submit" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR"%>">Salvar</button>

    </fieldset>
</form>
<%@include file="footer.jsp" %>