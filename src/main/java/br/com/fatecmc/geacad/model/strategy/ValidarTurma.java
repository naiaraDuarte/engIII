package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.Aluno;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.domain.Turma;

public class ValidarTurma implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        Aluno aluno = (Aluno) entidade;
        
        if (aluno.getTurma() == null) {
            return "O aluno deve ser matriculado em uma turma";
        }
            Turma t = aluno.getTurma();
            ValidarLimiteAlunosTurma vTurma = new ValidarLimiteAlunosTurma();
            String msgEnd = vTurma.process(t);
            if (msgEnd != null) {
                return msgEnd;
            }
            
        
        return null;
    }
}
