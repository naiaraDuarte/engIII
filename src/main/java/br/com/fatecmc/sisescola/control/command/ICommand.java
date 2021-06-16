package br.com.fatecmc.sisescola.control.command;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public interface ICommand {
    
    public Object execute(EntidadeDominio entidade);
    
}
