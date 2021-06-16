package br.com.fatecmc.sisescola.control.command;

import br.com.fatecmc.sisescola.control.facade.Facade;
import br.com.fatecmc.sisescola.control.facade.IFacade;

public abstract class AbstractCommand implements ICommand {
    protected IFacade facade = new Facade();
}
