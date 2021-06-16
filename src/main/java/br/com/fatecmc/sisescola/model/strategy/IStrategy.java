package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public interface IStrategy {
    
    public String process(EntidadeDominio entidade);
    
}
