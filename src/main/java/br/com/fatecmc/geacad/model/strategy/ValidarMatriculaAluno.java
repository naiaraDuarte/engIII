package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.Aluno;
import br.com.fatecmc.geacad.model.domain.Endereco;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

public class ValidarMatriculaAluno implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {

        if (entidade instanceof Aluno) {
            Aluno aluno = (Aluno) entidade;

            String nome = aluno.getNome();
            String ra = aluno.getRa();

            StringBuilder sb = new StringBuilder();
            //Incluir os outros campos
            if (nome == null || ra == null) {
                sb.append("Nome, e Ra são de preenchimento obrigatorio!");
            } else if (nome.trim().equals("") || ra.trim().equals("")) {
                sb.append("Nome, e Ra são de preenchimento obrigatorio!");
            }

            Endereco e = aluno.getEndereco();
            ValidarEndereco vEnd = new ValidarEndereco();
            String msgEnd = vEnd.process(e);
            if (msgEnd != null) {
                sb.append(msgEnd);

            }
            if (sb.length() > 0) {
                return sb.toString();
            } else {
                return null;
            }

        }
        return null;

    }
}
