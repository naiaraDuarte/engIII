package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.Aluno;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

public class ValidarCpf implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {

        if (entidade instanceof Aluno) {
            Aluno a = (Aluno) entidade;

            if (a.getCpf() == null) {
                return "CPF é obrigatorio!";
            } else if (a.getCpf() != null) {
                if (a.getCpf().length() != 11) {
                    return "CPF deve conter 11 digitos!";
                }
            }

        }
        return null;
    }
}