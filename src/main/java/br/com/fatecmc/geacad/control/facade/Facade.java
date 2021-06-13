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
        daos.put(Professor.class.getName(), new ProfessorDAO());
        daos.put(Turma.class.getName(), new TurmaDAO());
    }

    private void initStrategy() {
        rns = new HashMap<>();

        ValidarExistencia validar_existencia = new ValidarExistencia();
        ValidarCpf validar_cpf = new ValidarCpf();
        ValidarTurma validar_turma = new ValidarTurma();
        //ValidarLimiteAlunosTurma validar_limite_alunos_turma = new ValidarLimiteAlunosTurma();
        ValidarMatriculaAluno validar_matricula_aluno = new ValidarMatriculaAluno();
        ValidarDisciplina validar_disciplina = new ValidarDisciplina();
        ValidarCargaHoraria validar_carga_horaria = new ValidarCargaHoraria();

        List<IStrategy> rns_aluno = new ArrayList<>();
        rns_aluno.add(validar_turma);
        rns_aluno.add(validar_matricula_aluno);
        rns_aluno.add(validar_cpf);
        //rns_aluno.add(validar_existencia);
        //rns_aluno.add(validar_limite_alunos_turma);
        
        
        //rns.put(Aluno.class.getName(), rns_aluno);
        

        List<IStrategy> rns_disciplina = new ArrayList<>();
        //rns_disciplina.add(validar_turma);
        //rns_disciplina.add(validar_disciplina);

        List<IStrategy> rns_professor = new ArrayList<>();
        //rns_professor.add(validar_cpf);
        //rns_professor.add(validar_existencia);
        // rns_professor.add(validar_carga_horaria);

        List<IStrategy> rns_turma = new ArrayList<>();

        rns.put(Aluno.class.getName(), rns_aluno);
        rns.put(Disciplina.class.getName(), rns_disciplina);
        rns.put(Professor.class.getName(), rns_professor);
        rns.put(Turma.class.getName(), rns_turma);
    }

    private String processStrategys(EntidadeDominio entidade) {
        List<IStrategy> regras = rns.get(entidade.getClass().getName());
        StringBuilder final_msgn = new StringBuilder();
        
        if (regras != null) {
            for (IStrategy strategy : regras) {
                String msgn = strategy.process(entidade);

                if (msgn != null) {
                    final_msgn.append(msgn);
                    final_msgn.append("\n");
                }
            }
        }

        return (final_msgn.length() > 0) ? final_msgn.toString() : null;
    }

    @Override
    public String salvar(EntidadeDominio entidade) {
        String msg = processStrategys(entidade);
        String nmClasse = entidade.getClass().getName();
        if (msg == null) {
            IDAO dao = daos.get(nmClasse);
            dao.salvar(entidade);
        } else {
            return msg;
        }
        return null;
    }

    /*String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao;
            if (entidade instanceof Aluno) {
                dao = daos.get(new Aluno().getClass().getName());
                ((Aluno) entidade).setId(dao.salvar(entidade));
            } else if (entidade instanceof Professor) {
                dao = daos.get(new Professor().getClass().getName());
                ((Professor) entidade).setId(dao.salvar(entidade));
            } else if (entidade instanceof Turma) {
                dao = daos.get(new Turma().getClass().getName());
                ((Turma) entidade).setId(dao.salvar(entidade));
            } else if (entidade instanceof Disciplina) {
                dao = daos.get(new Disciplina().getClass().getName());
                ((Disciplina) entidade).setId(dao.salvar(entidade));
            }
            dao = daos.get(entidade.getClass().getName());
            dao.salvar(entidade);
            return null;
        } else {
            return error_message;
        }*/
    @Override
    public String alterar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao;
            /*if (entidade instanceof Aluno || entidade instanceof Professor) {
                dao = daos.get(new Aluno().getClass().getName());
                dao.alterar(entidade);
            }*/
            dao = daos.get(entidade.getClass().getName());
            dao.alterar(entidade);
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public String excluir(EntidadeDominio entidade) {
        //String error_message = processStrategys(entidade);

        IDAO dao;
        dao = daos.get(entidade.getClass().getName());
        dao.excluir(entidade.getId());
        /*if (entidade instanceof Aluno) {
            dao = daos.get(new Aluno().getClass().getName());
            dao.excluir(((Aluno) entidade).getId());
        } else if (entidade instanceof Professor) {
            dao = daos.get(new Professor().getClass().getName());
            dao.excluir(((Professor) entidade).getId());
            return null;
        }*/
        return null;
    }

    @Override
    public Object consultar(EntidadeDominio entidade) {
        //String error_message = processStrategys(entidade);
        IDAO dao = daos.get(entidade.getClass().getName());
        int id = entidade.getId();
            if (id != 0) {
                return dao.consultar(entidade);
            } else {
               return dao.consultar();
            }
            //return null;
            //return error_message;
        }
        
    }

