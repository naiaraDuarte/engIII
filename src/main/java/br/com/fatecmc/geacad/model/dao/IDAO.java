package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import java.util.List;

/**
 *
 * @author paulo
 */
public interface IDAO {
    
    public int salvar(EntidadeDominio entidade);
    public boolean alterar(EntidadeDominio entidade);
    public boolean excluir(int id);
    public List consultar();
    public List consultar(int id);
    
}
