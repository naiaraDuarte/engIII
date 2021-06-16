<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%
    String nome = request.getParameter("nome");
    String cargah = request.getParameter("cargah");
    //String cargah = request.getParameter("cargah");
    String id = request.getParameter("id");

    if (nome == null) {
        nome = "";
    }
    if (cargah == null) {
        cargah = "";
    }
    
    if (id == null)
        id = "";
%>
<div class="conteudo">
    <div class="titulo">
        <h3> <i class="fas fa-angle-right"></i> Disciplina</h3>
    </div>
    <hr/>
<form action="./Disciplina" method="post">
    <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" style="width: 20em" value="<%=nome%>">
            </div>
        </div> 

        <div class="form-group col-md-6">
            <label for="cargah">Carga Horária</label>
            <input type="text" id="cargah" name="cargah" style="width: 20em" value="<%=cargah%>">
        </div>
        <input type="hidden" id="id" name="id" value="<%=id%>">
       
        <div class="form-row botao">
            <button class="btn btn-primary" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR"%>">Salvar</button>
        </div>
    </form>
</div> 
<%@include file="footer.jsp" %>