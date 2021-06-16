package br.com.fatecmc.sisescola.control.facade;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public interface IFacade {
    
    public String salvar(EntidadeDominio entidade);
    public String alterar(EntidadeDominio entidade);
    public String excluir(EntidadeDominio entidade);
    public Object consultar(EntidadeDominio entidade);
    
}
