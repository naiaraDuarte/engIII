<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%
    String status = request.getParameter("status");
    String ra = request.getParameter("ra");
    String turma = request.getParameter("turma");
    String pessoa = request.getParameter("pessoa");
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String rg = request.getParameter("rg");
    String cpf = request.getParameter("cpf");
    String datanasc = request.getParameter("datanasc");
    String sexo = request.getParameter("sexo");
    String id = request.getParameter("id");
    String telefone = request.getParameter("telefone");

    if (status == null) {
        status = "";
    }
    if (ra == null) {
        ra = "";
    }
    if (turma == null) {
        turma = "";
    }
    if (pessoa == null) {
        pessoa = "";
    }
    if (nome == null) {
        nome = "";
    }
    if (email == null) {
        email = "";
    }
    if (rg == null) {
        rg = "";
    }
    if (cpf == null) {
        cpf = "";
    }
    if (datanasc == null) {
        datanasc = "";
    }
    if (sexo == null) {
        sexo = "";
    }
    if (id == null) {
        id = "";
    }
    if (telefone == null)
        telefone = "";
%>
<div class="conteudo">
    <div class="titulo">
        <h3> <i class="fas fa-angle-right"></i> Aluno</h3>
    </div>
    <hr/>




    <form action="./Aluno" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" class="form-control" placeholder="Digite o nome" value="<%=nome%>" >
            </div>
            <div class="form-group col-md-6">
                <label for="cpf">CPF: </label>
                <input type="text" id="cpf" name="cpf" class="form-control" placeholder="Digite o cpf" value="<%=cpf%>">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="ra">RA: </label>
                <input type="text" id="ra" name="ra" class="form-control" placeholder="Digite o ra" value="<%=ra%>">
            </div>
            <div class="form-group col-md-6">
                <label for="datanasc">Data de Nascimento:</label>
                <input type="date" id="datanasc" class="form-control" name="datanasc" value="<%=datanasc%>">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="ra">Telefone: </label>
                <input type="text" id="telefone" name="telefone" class="form-control" placeholder="Digite o telefone" value="<%=telefone%>">
            </div>
            <div class="form-group col-md-6">
                <label for="ra">Sexo: </label>
                <div class="custom-control custom-radio custom-control-inline">
                    <label class="form-check-label" for="masculino">
                        <input class="form-check-input" type="radio" id="sexo" name="sexo" value="<%=sexo%>">
                        Masculino
                    </label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <label class="form-check-label" for="feminino">
                        <input class="form-check-input" type="radio" id="sexo" name="sexo" value="<%=sexo%>">
                        Feminino
                    </label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <label class="form-check-label" for="indefinido">
                        <input class="form-check-input" type="radio" id="sexo" name="sexo" value="<%=sexo%>">
                        Indefinido
                    </label>
                </div>
                <input type="hidden" id="pessoa" name="pessoa" value="<%=pessoa%>">
                <input type="hidden" id="id" name="id" value="<%=id%>">
            </div>
        </div>
            <div class="form-row botao">
                <button class="btn btn-primary" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR"%>">Salvar</button>
            </div>
        <!-- <fieldset>
 
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
 
             <button class="botao submit" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR"%>">Salvar</button>
 
         </fieldset>-->
    </form>
</div>
<%@include file="footer.jsp" %>