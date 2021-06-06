package br.com.fatecmc.geacad.control.viewhelper;

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
        double salario =   ParameterParser.toDouble(request.getParameter("salario"));
        String titulacao = request.getParameter("titulacao");
        String nome =      request.getParameter("nome");
        String rg =        request.getParameter("rg");
        String cpf =       request.getParameter("cpf");
        Date dt_nasc =     ParameterParser.toDate(request.getParameter("datanasc"));
        String sexo =      request.getParameter("sexo");
        int id_prof =      ParameterParser.toInt(request.getParameter("id"));
        
        Professor professor = new Professor(salario, titulacao, nome, rg, cpf, dt_nasc, sexo, id_prof);
        return professor;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/geacad/faces/ListTurma.xhtml");
    }
    
}
