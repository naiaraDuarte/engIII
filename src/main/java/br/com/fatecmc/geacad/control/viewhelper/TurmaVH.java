package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Disciplina;
import br.com.fatecmc.geacad.model.domain.Turma;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ParameterParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurmaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String descricao = request.getParameter("descricao");
        String ano =   request.getParameter("datainicio");
        String periodo =   request.getParameter("periodo");
        int id_disciplina = ParameterParser.toInt(request.getParameter("disciplina"));
        int id_turma =     ParameterParser.toInt(request.getParameter("id"));
        
        Disciplina disciplina = new Disciplina();
        disciplina.setId(id_disciplina);
                      
        Turma turma = new Turma(descricao, ano, periodo, disciplina, id_turma);
        return turma;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/geacad/faces/ListTurma.xhtml");
    }
    
}
