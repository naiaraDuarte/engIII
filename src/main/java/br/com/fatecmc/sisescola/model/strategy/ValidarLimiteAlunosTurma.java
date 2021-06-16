package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.domain.Aluno;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import br.com.fatecmc.sisescola.model.domain.Turma;
import java.util.List;

public class ValidarLimiteAlunosTurma implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        /*Turma turma = (Turma) entidade;
        List<Aluno> alunos = turma.getAlunos();

        if (alunos != null) {
            if (alunos.size() > 30) {
                return "Limite de alunos atingido nessa turma!";
            }

        }
        
    }*/
        return null;
    }
}
