package br.com.fatecmc.sisescola.control.viewhelper;

import br.com.fatecmc.sisescola.model.domain.Turma;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import br.com.fatecmc.sisescola.util.ParameterParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurmaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String ano = request.getParameter("ano");
        String periodo = request.getParameter("periodo");
        int id_turma = ParameterParser.toInt(request.getParameter("id"));

        Turma turma = new Turma(nome, ano, periodo, id_turma);
        turma.setId(id_turma);
        return turma;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/sisescola/faces/ListTurma.jsp");
    }

}
