package br.com.fatecmc.sisescola.control.command;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public class SalvarCommand extends AbstractCommand {
    
    @Override
    public Object execute(EntidadeDominio entidade) {		
        return facade.salvar(entidade);
    }
    
}
