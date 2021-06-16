package br.com.fatecmc.sisescola.control.command;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand {
    
    @Override
    public Object execute(EntidadeDominio entidade) {		
        return facade.excluir(entidade);
    }
    
}
