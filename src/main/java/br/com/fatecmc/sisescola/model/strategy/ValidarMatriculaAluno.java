package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.domain.Aluno;
import br.com.fatecmc.sisescola.model.domain.Endereco;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public class ValidarMatriculaAluno implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {

        if (entidade instanceof Aluno) {
            Aluno aluno = (Aluno) entidade;

            String nome = aluno.getNome();
            String ra = aluno.getRa();
            String telefone = aluno.getTelefone();
            String sexo =  aluno.getSexo();        

            StringBuilder sb = new StringBuilder();
            //Incluir os outros campos
            if (nome == null || ra == null||telefone == null || sexo == null) {
                sb.append("Todos os dados são obrigatorios");
            } else if (nome.trim().equals("") || ra.trim().equals("") || telefone.trim().equals("") ||sexo.trim().equals("")) {
                sb.append("Todos os dados são obrigatorios");
            }
            if (aluno.getRa() != null) {
                if (aluno.getRa().length() != 13) {
                    return "RA deve conter 13 digitos!";
                }
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
