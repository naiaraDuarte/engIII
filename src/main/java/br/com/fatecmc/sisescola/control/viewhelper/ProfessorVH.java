package br.com.fatecmc.sisescola.control.viewhelper;

import br.com.fatecmc.sisescola.model.domain.Disciplina;
import br.com.fatecmc.sisescola.model.domain.Endereco;
import br.com.fatecmc.sisescola.model.domain.Professor;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import br.com.fatecmc.sisescola.util.ParameterParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfessorVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String titulacao = request.getParameter("titulacao");
        String nome =      request.getParameter("nome");
        String telefone =  request.getParameter("telefone");
        String cpf =       request.getParameter("cpf");
        Date dt_nasc =     ParameterParser.toDate(request.getParameter("datanasc"));
        String sexo =      request.getParameter("sexo");
        //int id_endereco =  ParameterParser.toInt (request.getParameter("endereco"));
        int id_professor =      ParameterParser.toInt(request.getParameter("id"));
        int id_disciplina = ParameterParser.toInt(request.getParameter("disciplina"));
        
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
        
        
        Disciplina disciplina = new Disciplina();
        disciplina.setId(id_disciplina);
        
        Professor professor = new Professor(titulacao, end, disciplina, nome, telefone, cpf, dt_nasc, sexo, id_professor);
        if (id_professor != 0) {
            Integer id_endereco = ParameterParser.toInt(request.getParameter("id_endereco"));
            if (id_endereco != 0) {
                end.setId(id_endereco);
                professor.setEndereco(end);
            } else {
                professor.setEndereco(end);
            }
        }
        return professor;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException { PrintWriter out;
        try {
            out = response.getWriter();
            if (resultado != null) {
                ;
                out.println(resultado);
            } else {
                response.sendRedirect("/sisescola/faces/ListProfessor.jsp");

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    
    }
    
}
