package br.com.fatecmc.sisescola.control.viewhelper;

import br.com.fatecmc.sisescola.model.domain.Disciplina;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import br.com.fatecmc.sisescola.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String nome =     request.getParameter("nome");
        int carga_hr =    ParameterParser.toInt(request.getParameter("cargah"));
        int id_disci =    ParameterParser.toInt(request.getParameter("id"));
        
        Disciplina disciplina = new Disciplina(nome, carga_hr, id_disci);
        return disciplina;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/sisescola/faces/ListDisciplina.jsp");
    }
    
}
