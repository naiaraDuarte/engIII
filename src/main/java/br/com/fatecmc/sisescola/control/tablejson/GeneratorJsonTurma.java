package br.com.fatecmc.sisescola.control.tablejson;

import br.com.fatecmc.sisescola.model.domain.Turma;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import java.util.List;

public class GeneratorJsonTurma implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if (!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for (EntidadeDominio e : entidades) {
                Turma t = (Turma) e;
                data += " ["
                        + "\"" + t.getId() + "\","
                        + "\"" + t.getNome() + "\","
                        + "\"" + t.getAno() + "\","
                        + "\"" + t.getPeriodo()+ "\","
                        + "\"<a href='/sisescola/FormTurma.jsp"
                        + "?nome=" + t.getNome()
                        + "&ano=" + t.getAno()
                        + "&periodo=" + t.getPeriodo()
                        + "&id=" + t.getId()
                        + "'>Editar</a>\","
                        + "\"<a href='/sisescola/Turma?operacao=EXCLUIR"
                        + "&id=" + t.getId()
                        + "'>Excluir</a>\""
                        + "]";
                if (cont < totalLista) {
                    data += ",";
                }
                cont++;
            }
            json = "{"
                    + "  \"draw\": 1,"
                    + "  \"recordsTotal\": " + entidades.size() + ","
                    + "  \"recordsFiltered\": " + entidades.size() + ","
                    + "  \"data\": ["
                    + data
                    + "]"
                    + "}";
        }
        return json;
    }

}
