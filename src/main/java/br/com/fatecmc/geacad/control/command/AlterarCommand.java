package br.com.fatecmc.geacad.control.command;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

public class AlterarCommand extends AbstractCommand {
    
    @Override
    public Object execute(EntidadeDominio entidade) {		
        return facade.alterar(entidade);
    }
    
}
