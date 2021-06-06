package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Endereco;
import br.com.fatecmc.geacad.model.domain.Professor;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ParameterParser;
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
        int id_endereco =  ParameterParser.toInt (request.getParameter("endereco"));
        int id_prof =      ParameterParser.toInt(request.getParameter("id"));
        
        Endereco endereco = new Endereco();
        endereco.setId(id_endereco); 
        
        Professor professor = new Professor(titulacao, endereco, nome, telefone, cpf, dt_nasc, sexo, id_prof);
        return professor;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/geacad/faces/ListTurma.xhtml");
    }
    
}
