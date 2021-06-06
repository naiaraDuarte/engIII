package br.com.fatecmc.geacad.control.command;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

public interface ICommand {
    
    public Object execute(EntidadeDominio entidade);
    
}
