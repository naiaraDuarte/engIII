package br.com.fatecmc.geacad.control;

import br.com.fatecmc.geacad.control.tablejson.GeneratorJsonEndereco;
import br.com.fatecmc.geacad.control.tablejson.*;
import br.com.fatecmc.geacad.control.command.ConsultarCommand;
import java.io.IOException;
import br.com.fatecmc.geacad.model.domain.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TableConstructor", urlPatterns = {"/TableConstructor"})
public class TableConstructor extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Map<String, EntidadeDominio> entitys;
    private static Map<String, IGeneratorJson> generators;
       
    public TableConstructor() {
        super();
        entitys = new HashMap<>();
        entitys.put("Aluno", new Aluno());
        entitys.put("Disciplina", new Disciplina());	
        entitys.put("Professor", new Professor());
        entitys.put("Turma", new Turma());
        entitys.put("Endereco", new Endereco());
        
        generators = new HashMap<>();
        generators.put("Aluno", new GeneratorJsonAluno());
        generators.put("Disciplina", new GeneratorJsonDisciplina());
        generators.put("Professor", new GeneratorJsonProfessor());
        generators.put("Turma", new GeneratorJsonTurma());
        generators.put("Endereco", new GeneratorJsonEndereco());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tabela = request.getParameter("tabela");
        List<EntidadeDominio> entidades = (List<EntidadeDominio>) 
                new ConsultarCommand().execute(entitys.get(tabela));
        String json = generators.get(tabela).gerar(entidades);
        
        response.setStatus(200);
        response.getWriter().write(json);
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
	
}
