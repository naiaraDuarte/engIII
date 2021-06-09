package br.com.fatecmc.geacad.control.facade;

import br.com.fatecmc.geacad.model.dao.*;
import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.model.strategy.*;
import java.util.*;

public class Facade implements IFacade {
    private Map<String, IDAO> daos;
    private Map<String, List<IStrategy>> rns;

    public Facade() {
        initDAO();
        initStrategy();
    }

    private void initDAO() {
        daos = new HashMap<>();
        daos.put(Aluno.class.getName(), new AlunoDAO());
        daos.put(Disciplina.class.getName(), new DisciplinaDAO());
        daos.put(Endereco.class.getName(), new EnderecoDAO());
        daos.put(Professor.class.getName(), new ProfessorDAO());
        daos.put(Turma.class.getName(), new TurmaDAO());
    }

    private void initStrategy() {
        rns = new HashMap<>();

        ValidarExistenciaAluno validar_existencia_aluno = new ValidarExistenciaAluno(); 
        ValidarGradeCurricularAluno validar_grade_curricular_aluno = new ValidarGradeCurricularAluno();
        ValidarLimiteAlunosTurma validar_limite_alunos_turma = new ValidarLimiteAlunosTurma();
        ValidarMatriculaAluno validar_matricula_aluno = new ValidarMatriculaAluno();
        //
        
        List<IStrategy> rns_aluno = new ArrayList<>();
        rns_aluno.add(validar_existencia_aluno);
        
        List<IStrategy> rns_curso = new ArrayList<>();
        rns_curso.add(validar_matricula_aluno);
        
        List<IStrategy> rns_disciplina = new ArrayList<>();
        rns_disciplina.add(validar_grade_curricular_aluno);
                 
        List<IStrategy> rns_professor = new ArrayList<>();
        
        List<IStrategy> rns_turma = new ArrayList<>();
        rns_turma.add(validar_limite_alunos_turma);

        rns.put(Aluno.class.getName(), rns_aluno);
        rns.put(Disciplina.class.getName(), rns_disciplina);
        rns.put(Professor.class.getName(), rns_professor);
        rns.put(Turma.class.getName(), rns_turma);
    }
    
    private String processStrategys(EntidadeDominio entidade) {
        List<IStrategy> regras = rns.get(entidade.getClass().getName());

        StringBuilder final_message = new StringBuilder();
        if (regras != null) {
            for (IStrategy strategy : regras) {
                String message = strategy.process(entidade);

                if(message != null) {
                    final_message.append(message);
                    final_message.append("\n");
                }
            }
        }

        return(final_message.length() > 0) ? final_message.toString() : null;
    }
    
    @Override
    public String salvar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao;
            if(entidade instanceof Aluno){
                dao = daos.get(new Aluno().getClass().getName());
                ((Aluno) entidade).setId(dao.salvar(entidade));
            }else if(entidade instanceof Professor){
                dao = daos.get(new Professor().getClass().getName());
                ((Professor) entidade).setId(dao.salvar(entidade));
            }else if(entidade instanceof Turma){
                dao = daos.get(new Turma().getClass().getName());
                ((Turma) entidade).setId(dao.salvar(entidade));
            }
            else if(entidade instanceof Disciplina){
                dao = daos.get(new Disciplina().getClass().getName());
                ((Disciplina) entidade).setId(dao.salvar(entidade));
            }
            dao = daos.get(entidade.getClass().getName());
            dao.salvar(entidade);
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao;
            if(entidade instanceof Aluno || entidade instanceof Professor){
                dao = daos.get(new Aluno().getClass().getName());
                dao.alterar(entidade);
            }
            dao = daos.get(entidade.getClass().getName());
            dao.alterar(entidade);
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public String excluir(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao;
            dao = daos.get(entidade.getClass().getName());
            dao.excluir(entidade.getId());
            if(entidade instanceof Aluno){
                dao = daos.get(new Aluno().getClass().getName());
                dao.excluir(((Aluno) entidade).getId());
            }else if(entidade instanceof Professor){
                dao = daos.get(new Professor().getClass().getName());
                dao.excluir(((Professor) entidade).getId());
            }
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public Object consultar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            int id = entidade.getId();
            if(id != 0)
                return dao.consultar(id);
            else
                return dao.consultar();
        } else {
            return error_message;
        }
    }
    
}
