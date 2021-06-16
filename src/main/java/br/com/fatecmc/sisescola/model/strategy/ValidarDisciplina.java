package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.domain.Disciplina;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import br.com.fatecmc.sisescola.model.domain.Professor;
import java.util.List;

public class ValidarDisciplina implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        Professor professor = (Professor) entidade;
        /*List<Disciplina> disciplinas = professor.getDisciplinas();

        if (disciplinas == null || disciplinas.size() < 1 ) {
            return "O Professor deve lecionar ao menos uma disciplina";
        }*/
         
        int id = professor.getDisciplina().getId();

        if (id == 0) {
            return "O Professor deve estar vinculado a uma disciplina";
        }
        

        return null;

    }

}
