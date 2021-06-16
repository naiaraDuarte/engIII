package br.com.fatecmc.sisescola.control.viewhelper;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IViewHelper {
    
    public EntidadeDominio getEntidade(HttpServletRequest request);
	
    public void setView(Object resultado, HttpServletRequest request,
            HttpServletResponse response)throws ServletException, IOException;

}
