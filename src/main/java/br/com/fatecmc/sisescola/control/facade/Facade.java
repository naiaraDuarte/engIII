package br.com.fatecmc.sisescola.control.facade;

import br.com.fatecmc.sisescola.model.dao.DisciplinaDAO;
import br.com.fatecmc.sisescola.model.dao.ProfessorDAO;
import br.com.fatecmc.sisescola.model.dao.IDAO;
import br.com.fatecmc.sisescola.model.dao.AlunoDAO;
import br.com.fatecmc.sisescola.model.dao.TurmaDAO;
import br.com.fatecmc.sisescola.model.domain.Disciplina;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import br.com.fatecmc.sisescola.model.domain.Turma;
import br.com.fatecmc.sisescola.model.domain.Professor;
import br.com.fatecmc.sisescola.model.domain.Aluno;
import br.com.fatecmc.sisescola.model.strategy.ValidarCadastroProfessor;
import br.com.fatecmc.sisescola.model.strategy.ValidarLimiteAlunosTurma;
import br.com.fatecmc.sisescola.model.strategy.ValidarCpf;
import br.com.fatecmc.sisescola.model.strategy.ValidarTurma;
import br.com.fatecmc.sisescola.model.strategy.IStrategy;
import br.com.fatecmc.sisescola.model.strategy.ValidarMatriculaAluno;
import br.com.fatecmc.sisescola.model.strategy.ValidarDisciplina;
import br.com.fatecmc.sisescola.model.strategy.ValidarExistencia;
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
        ValidarLimiteAlunosTurma validar_limite_alunos_turma = new ValidarLimiteAlunosTurma();
        ValidarMatriculaAluno validar_matricula_aluno = new ValidarMatriculaAluno();
        ValidarDisciplina validar_disciplina = new ValidarDisciplina();
        ValidarCadastroProfessor validar_professor = new ValidarCadastroProfessor();
        
        List<IStrategy> rns_aluno = new ArrayList<>();
        rns_aluno.add(validar_turma);
        rns_aluno.add(validar_matricula_aluno);
        rns_aluno.add(validar_cpf);
        rns_aluno.add(validar_limite_alunos_turma);

        List<IStrategy> rns_professor = new ArrayList<>();
        rns_professor.add(validar_cpf);
        rns_professor.add(validar_professor);
        rns_professor.add(validar_disciplina);

        rns.put(Aluno.class.getName(), rns_aluno);
        rns.put(Professor.class.getName(), rns_professor);
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

    @Override
    public String alterar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao;
            
            dao = daos.get(entidade.getClass().getName());
            dao.alterar(entidade);
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public String excluir(EntidadeDominio entidade) {

        IDAO dao;
        dao = daos.get(entidade.getClass().getName());
        dao.excluir(entidade.getId());
        return null;
    }

    @Override
    public Object consultar(EntidadeDominio entidade) {
        IDAO dao = daos.get(entidade.getClass().getName());
        int id = entidade.getId();
            if (id != 0) {
                return dao.consultar(entidade);
            } else {
               return dao.consultar();
            }
        }
        
    }

