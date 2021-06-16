package br.com.fatecmc.sisescola.control;

import br.com.fatecmc.sisescola.control.viewhelper.TurmaVH;
import br.com.fatecmc.sisescola.control.viewhelper.AlunoVH;
import br.com.fatecmc.sisescola.control.viewhelper.IViewHelper;
import br.com.fatecmc.sisescola.control.viewhelper.ProfessorVH;
import br.com.fatecmc.sisescola.control.viewhelper.DisciplinaVH;
import br.com.fatecmc.sisescola.control.command.ExcluirCommand;
import br.com.fatecmc.sisescola.control.command.ConsultarCommand;
import br.com.fatecmc.sisescola.control.command.ICommand;
import br.com.fatecmc.sisescola.control.command.AlterarCommand;
import br.com.fatecmc.sisescola.control.command.SalvarCommand;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/Aluno", "/Disciplina", "/Professor", "/Turma"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String operacao = null;
    private static Map<String, ICommand> cmds;
    private static Map<String, IViewHelper> vhs;
    
    public Controller() {
        super();
        cmds = new HashMap<>();
        cmds.put("SALVAR", new SalvarCommand());
        cmds.put("ALTERAR", new AlterarCommand());
        cmds.put("EXCLUIR", new ExcluirCommand());	
        cmds.put("CONSULTAR", new ConsultarCommand());
        
        vhs = new HashMap<>();
        vhs.put("/sisescola/Aluno", new AlunoVH());
        vhs.put("/sisescola/Disciplina", new DisciplinaVH());
        vhs.put("/sisescola/Professor", new ProfessorVH());
        vhs.put("/sisescola/Turma", new TurmaVH());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        operacao = request.getParameter("operacao");
        
        String uri = request.getRequestURI();
        IViewHelper viewhelper = vhs.get(uri);
        EntidadeDominio entidade = viewhelper.getEntidade(request);

        ICommand command = cmds.get(operacao);
        Object message = command.execute(entidade);

        viewhelper.setView(message, request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet SisEscola - Sistema de Gestão Escolar";
    }

}
