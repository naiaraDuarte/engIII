package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.dao.AlunoDAO;
import br.com.fatecmc.sisescola.model.dao.IDAO;
import br.com.fatecmc.sisescola.model.domain.Aluno;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import java.util.List;

public class ValidarExistencia implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        /*AlunoDAO dao = new AlunoDAO();
        Aluno aluno =  (Aluno)entidade;
        
        String cpf = aluno.getCpf();
        Aluno a = new Aluno();
        a = dao.consult(cpf);
        int teste = a.getId();
        if (teste ){
            
        }*/
            
		
		return null;
    }
}    

