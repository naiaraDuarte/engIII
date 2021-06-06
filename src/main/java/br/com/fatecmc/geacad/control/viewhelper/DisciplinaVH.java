package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String nome =     request.getParameter("nome");
        int carga_hr =    ParameterParser.toInt(request.getParameter("cargahor"));
        int id_prof =     ParameterParser.toInt(request.getParameter("professor"));
        int id_disci =    ParameterParser.toInt(request.getParameter("id"));
        
        Professor professor  = new Professor();
        professor.setId(id_prof);       
        
        Disciplina disciplina = new Disciplina(nome, carga_hr, professor, id_disci);
        return disciplina;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/geacad/faces/ListTurma.xhtml");
    }
    
}
