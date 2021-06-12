package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.dao.AlunoDAO;
import br.com.fatecmc.geacad.model.dao.IDAO;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
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

