package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.*;
import java.util.List;

public class GeneratorJsonProfessor implements IGeneratorJson{

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if(!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for(EntidadeDominio e: entidades) {
                Professor p = (Professor) e;
                
                    data += " ["
                    +"\""+ p.getId() + "\","
                    +"\""+ p.getNome() + "\","
                    +"\""+ p.getTitulacao() + "\","
                    +"\""+ p.getTelefone()+ "\","
                    +"\""+ p.getCpf()+ "\","
                    +"\""+ p.getData_nascimento()+ "\","
                    +"\""+ p.getSexo()+ "\","
                    +"\"<a href='/geacad/faces/FormProfessor.jsp"
                    +"?ra=" +p.getTitulacao()
                    +"&disciplina="+ p.getDisciplina().getId()
                    +"&nome="+ p.getNome()
                    +"&telefone="+ p.getTelefone()
                    +"&cpf="+ p.getCpf()
                    +"&datanasc="+ p.getData_nascimento()
                    +"&sexo="+ p.getSexo()
                    +"&id="+ p.getId()
                    +"'>Editar</a>\","
                    +"\"<a href='/geacad/Professor?operacao=EXCLUIR"
                    +"&id="+ p.getId()
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
