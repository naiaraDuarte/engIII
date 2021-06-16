package br.com.fatecmc.sisescola.model.dao;

import br.com.fatecmc.sisescola.model.domain.Aluno;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import java.util.List;


public interface IDAO {
    
    public int salvar(EntidadeDominio entidade);
    public boolean alterar(EntidadeDominio entidade);
    public boolean excluir(int id);
    public List consultar();
    public List consultarId(int id);
    public List<EntidadeDominio> consultar(EntidadeDominio entidade);

    
    
}
