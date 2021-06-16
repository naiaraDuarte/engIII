package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.domain.Aluno;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public class ValidarTurma implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        Aluno aluno = (Aluno) entidade;
        int id = aluno.getTurma().getId();

        if (id == 0) {
            return "O aluno deve ser matriculado em uma turma";
        }
        
       /*Turma t = aluno.getTurma();
        ValidarLimiteAlunosTurma vTurma = new ValidarLimiteAlunosTurma();
        String msgEnd = vTurma.process(t);
        if (msgEnd != null) {
            return msgEnd;
        }*/

        return null;
    }
}
