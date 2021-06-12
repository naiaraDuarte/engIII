package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.Disciplina;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.domain.Professor;
import java.util.List;

public class ValidarDisciplina implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        Professor professor = (Professor) entidade;
        List<Disciplina> disciplinas = professor.getDisciplinas();

        if (disciplinas != null) {
            if (disciplinas.size() < 1) {
                return "O Professor deve lecionar ao menos uma disciplina";
            }

        }
        return null;
    }

}
