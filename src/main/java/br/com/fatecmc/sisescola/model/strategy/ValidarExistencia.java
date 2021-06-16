package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.dao.AlunoDAO;
import br.com.fatecmc.sisescola.model.dao.IDAO;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import java.util.List;

public class ValidarExistencia implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        IDAO dao = new AlunoDAO();
        
		List<EntidadeDominio> alunos = dao.consultar(entidade);
		if(alunos != null && alunos.size()>0) {
			//return "Aluno já cadastrado!";
                        return null;
		}
		return null;
    }
}    

