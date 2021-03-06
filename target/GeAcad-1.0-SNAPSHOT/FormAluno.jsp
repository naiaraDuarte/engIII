<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%
    String ra = request.getParameter("ra");
    String turma = request.getParameter("turma");
    String nome = request.getParameter("nome");
    String cpf = request.getParameter("cpf");
    String datanasc = request.getParameter("datanasc");
    String sexo = request.getParameter("sexo");
    String id = request.getParameter("id");
    String telefone = request.getParameter("telefone");

    String logradouro = request.getParameter("logradouro");
    String numero = request.getParameter("numero");
    String bairro = request.getParameter("bairro");
    String cidade = request.getParameter("cidade");
    String uf = request.getParameter("uf");
    String cep = request.getParameter("cep");
    String id_endereco = request.getParameter("id_endereco");

    if (ra == null) {
        ra = "";
    }
    if (turma == null) {
        turma = "";
    }
    if (nome == null) {
        nome = "";
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
    if (telefone == null) {
        telefone = "";
    }
    if (logradouro == null) {
        logradouro = "";
    }
    if (cidade == null) {
        cidade = "";
    }
    if (bairro == null) {
        bairro = "";
    }
    if (uf == null) {
        uf = "";
    }
    if (cep == null) {
        cep = "";
    }


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
                <label for="turma">Turma </label>
                <input type="text" id="turma" name="turma" class="form-control" placeholder="Digite a turma" value="<%=turma%>">
            </div>
            <!-- SELECT COISADO -->
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="id_turma">Turma: </label>
                    <select class="input" id="id_turma" name="id_turma">
                        <option value="<%=turma%>">Nome da Turma</option>
                    </select>
                </div>
            </div>
            <input type="hidden" id="id" name="id" value="<%=id%>">
            <!-- SELECT COISADO -->
            <div class="form-group">
                <label for="exampleFormControlSelect1" >Turma</label>
                <select class="form-control" name="turma" id="exampleFormControlSelect1">
                    <option value="<%=turma%>"></option>
                </select>
            </div>
            <!-- SELECT COISADO --> 
            <div class="form-group col-md-6">
                <label for="ra">Sexo: </label>
                <div class="custom-control custom-radio custom-control-inline">
                    <label class="form-check-label" for="masculino">
                        <input class="form-check-input" type="radio" id="sexo" name="sexo" value="M">
                        Masculino
                    </label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <label class="form-check-label" for="feminino">
                        <input class="form-check-input" type="radio" id="sexo" name="sexo" value="F">
                        Feminino
                    </label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <label class="form-check-label" for="indefinido">
                        <input class="form-check-input" type="radio" id="sexo" name="sexo" value="I">
                        Indefinido
                    </label>
                </div>
                <input type="hidden" id="id" name="id" value="<%=id%>">
                <input type="hidden" id="id_endereco" name="id_endereco" value="<%=id_endereco%>">
            </div>
        </div>
        <div class="titulo">
            <h3> <i class="fas fa-angle-right"></i> Endere??o</h3>
        </div>
        <hr/>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="logradouro">Logradouro: </label>
                <input type="text" id="logradouro" name="logradouro" class="form-control" placeholder="Logradouro" value="<%=logradouro%>">
            </div>
            <div class="form-group col-md-6">
                <label for="numero"> Numero:</label>
                <input type="number" id="numero" class="form-control" name="numero" value="<%=numero%>">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="bairro">Bairro: </label>
                <input type="text" id="bairro" name="bairro" class="form-control" placeholder="bairro" value="<%=bairro%>">
            </div>
            <div class="form-group col-md-6">
                <label for="cidade"> Cidade: </label>
                <input type="text" id="cidade" class="form-control" name="cidade" value="<%=cidade%>">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="uf">UF: </label>
                <input type="text" id="bairro" name="uf" class="form-control" placeholder="UF" value="<%=uf%>">
            </div>
            <div class="form-group col-md-6">
                <label for="cep"> CEP: </label>
                <input type="text" id="cep" class="form-control" name="cep" value="<%=cep%>">
            </div>
        </div>


        <div class="form-row botao">
            <button class="btn btn-primary" type="submit" name="operacao" value="<%= id == "" ? "SALVAR" : "ALTERAR"%>">Salvar</button>
        </div>
    </form>
</div>       

<%@include file="footer.jsp" %>