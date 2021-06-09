package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.*;
import java.util.List;

public class GeneratorJsonDisciplina implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if(!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for(EntidadeDominio e: entidades) {
                Disciplina d = (Disciplina) e;
                data += " ["
                    +"\""+ d.getId() + "\","
                    +"\""+ d.getNome() + "\","
                    +"\""+ d.getCarga_horaria() + "\","
                    +"\"<a href='/geacad/FormDisciplina.jsp"
                    +"?nome="+ d.getNome()
                    +"&cargahor="+ d.getCarga_horaria()
                    +"&id="+ d.getId()
                    +"'>Editar</a>\","
                    +"\"<a href='/geacad/Disciplina?operacao=EXCLUIR"
                    +"&id="+ d.getId()
                    +"'>Excluir</a>\""
                    +"]";
                if(cont < totalLista){
                    data += ",";
                }
                cont++;
            }
            json = "{"
                + "  \"draw\": 1,"
                + "  \"recordsTotal\": "+ entidades.size() +","
                + "  \"recordsFiltered\": "+ entidades.size() +","
                + "  \"data\": ["+
                data +
                "]"+
                "}";
        }
        return json;
    }

}
