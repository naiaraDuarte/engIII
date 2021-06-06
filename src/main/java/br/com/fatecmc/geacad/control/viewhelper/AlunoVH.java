package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Aluno;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.domain.Turma;
import br.com.fatecmc.geacad.util.ParameterParser;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlunoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String ra =     request.getParameter("ra");
        int id_turma =  ParameterParser.toInt(request.getParameter("turma"));
        String nome =   request.getParameter("nome");
        String rg =     request.getParameter("rg");
        String cpf =    request.getParameter("cpf");
        Date dt_nasc =  ParameterParser.toDate(request.getParameter("datanasc"));
        String sexo =   request.getParameter("sexo");
        int id_aluno =  ParameterParser.toInt(request.getParameter("id"));
        
        Turma turma  = new Turma();
        turma.setId(id_turma);
        
        Aluno aluno = new Aluno( ra, turma, nome, rg, cpf, dt_nasc, sexo, id_aluno);
        return aluno;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/geacad/faces/ListAluno.xhtml");
    }
    
}
