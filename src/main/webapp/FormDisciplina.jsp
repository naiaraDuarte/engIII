<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%
    String nome = request.getParameter("nome");
    String cargahor = request.getParameter("cargah");
    String id = request.getParameter("id");

    if (nome == null) {
        nome = "";
    }
    if (cargahor == null) {
        cargahor = "";
    }
    
    if (id == null)
        id = "";
%>

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
       
        <div class="form-row botao">
            <button class="btn btn-primary" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR"%>">Salvar</button>
        </div>
    </form>
</div> 
<%@include file="footer.jsp" %>