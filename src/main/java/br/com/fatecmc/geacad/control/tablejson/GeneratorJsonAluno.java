package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.*;
import java.util.List;

public class GeneratorJsonAluno implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if (!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for (EntidadeDominio e : entidades) {
                Aluno a = (Aluno) e;
                data += " ["
                        + "\"" + a.getId() + "\","
                        + "\"" + a.getNome() + "\","
                        + "\"" + a.getRa() + "\","
                        + "\"" + a.getTurma().getId() + "\","
                        + "\"" + a.getTelefone() + "\","
                        + "\"" + a.getCpf() + "\","
                        + "\"" + a.getData_nascimento() + "\","
                        + "\"" + a.getSexo() + "\","
                        + "\"<a href='/geacad/faces/FormAluno.jsp"
                        + "?ra=" + a.getRa()
                        + "&turma=" + a.getTurma().getId()
                        + "&nome=" + a.getNome()
                        + "&telefone=" + a.getTelefone()
                        + "&cpf=" + a.getCpf()
                        + "&datanasc=" + a.getData_nascimento()
                        + "&sexo=" + a.getSexo()
                        + "&id=" + a.getId()
                        + "&id_endereco=" + a.getEndereco().getId()
                        + "'>Editar</a>\","
                        + "\"<a href='/geacad/Aluno?operacao=EXCLUIR"
                        + "&id=" + a.getId()
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
