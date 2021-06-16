package br.com.fatecmc.sisescola.control.tablejson;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import java.util.List;

public interface IGeneratorJson {
	
    public String gerar(List<EntidadeDominio> entidades);

}
