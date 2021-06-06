package br.com.fatecmc.geacad.control.command;

import br.com.fatecmc.geacad.control.facade.Facade;
import br.com.fatecmc.geacad.control.facade.IFacade;

public abstract class AbstractCommand implements ICommand {
    protected IFacade facade = new Facade();
}
