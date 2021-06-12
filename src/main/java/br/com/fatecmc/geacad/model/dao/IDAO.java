package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import java.util.List;


public interface IDAO {
    
    public int salvar(EntidadeDominio entidade);
    public boolean alterar(EntidadeDominio entidade);
    public boolean excluir(int id);
    public List consultar();
    public List consultarId(int id);
    public List<EntidadeDominio> consultar(EntidadeDominio entidade);
    
}
