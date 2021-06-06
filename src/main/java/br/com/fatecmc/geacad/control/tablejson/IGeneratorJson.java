package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import java.util.List;

public interface IGeneratorJson {
	
    public String gerar(List<EntidadeDominio> entidades);

}
