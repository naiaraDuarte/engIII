package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Aluno;
import br.com.fatecmc.geacad.model.domain.Endereco;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.domain.Turma;
import br.com.fatecmc.geacad.util.ParameterParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlunoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        String ra = request.getParameter("ra");
        int id_turma = ParameterParser.toInt(request.getParameter("turma"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        Date dt_nasc = ParameterParser.toDate(request.getParameter("datanasc"));
        String sexo = request.getParameter("sexo");
        int id_aluno = ParameterParser.toInt(request.getParameter("id"));
        String telefone = request.getParameter("telefone");

        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");

        Endereco end = new Endereco();
        end.setLogradouro(logradouro);
        end.setBairro(bairro);
        end.setCidade(cidade);
        end.setEstado(uf);
        end.setNumero(numero);
        end.setCep(cep);

        Turma turma = new Turma();
        turma.setId(id_turma);

        Aluno aluno = new Aluno(ra, turma, end, nome, telefone, cpf, dt_nasc, sexo, id_aluno);
        aluno.setEndereco(end);
        //String ra, Turma turma, Endereco endereco, String nome, String telefone, String cpf, Date data_nascimento, String sexo, int id
        return aluno;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out;
        try {
            out = response.getWriter();
            if (resultado != null) {
                
                out.println(resultado);
            } else {
                response.sendRedirect("/geacad/faces/ListAluno.jsp");

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // response.sendRedirect("/geacad/faces/ListAluno.jsp");
    }

}
