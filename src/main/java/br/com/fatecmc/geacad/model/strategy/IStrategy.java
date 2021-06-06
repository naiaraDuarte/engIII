package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

public interface IStrategy {
    
    public String process(EntidadeDominio entidade);
    
}
