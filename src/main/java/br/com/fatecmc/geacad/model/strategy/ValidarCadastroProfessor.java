package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.Endereco;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.domain.Professor;

public class ValidarCadastroProfessor implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        
        if (entidade instanceof Professor) {
            Professor professor = (Professor) entidade;

            String nome = professor.getNome();
            String titulacao = professor.getTitulacao();
            String telefone = professor.getTelefone();
            String sexo = professor.getSexo();

            StringBuilder sb = new StringBuilder();
            //Incluir os outros campos
            if (nome == null || titulacao == null || telefone == null || sexo == null) {
                sb.append("Todos os dados são obrigatorios");
            } else if (nome.trim().equals("") || titulacao.trim().equals("") || telefone.trim().equals("") || sexo.trim().equals("")) {
                sb.append("Todos os dados são obrigatorios");
            }

            Endereco e = professor.getEndereco();
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
