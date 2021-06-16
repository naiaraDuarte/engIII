package br.com.fatecmc.sisescola.control.tablejson;

import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;
import br.com.fatecmc.sisescola.model.domain.Professor;
import java.util.List;

public class GeneratorJsonProfessor implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if (!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for (EntidadeDominio e : entidades) {
                Professor a = (Professor) e;
                data += " ["
                        + "\"" + a.getId() + "\","
                        + "\"" + a.getNome() + "\","
                        + "\"" + a.getTitulacao() + "\","
                        + "\"" + a.getDisciplina().getId() + "\","
                        + "\"" + a.getTelefone() + "\","
                        + "\"" + a.getCpf() + "\","
                        + "\"" + a.getData_nascimento() + "\","
                        + "\"" + a.getSexo() + "\","                                               
                        + "\"<a href='/sisescola/faces/FormProfessor.jsp"
                        + "?titulacao=" + a.getTitulacao()
                        + "&disciplina=" + a.getDisciplina().getId()
                        + "&nome=" + a.getNome()
                        + "&telefone=" + a.getTelefone()
                        + "&cpf=" + a.getCpf()
                        + "&datanasc=" + a.getData_nascimento()
                        + "&sexo=" + a.getSexo()
                        + "&id=" + a.getId()
                        + "&logradouro=" + a.getEndereco().getLogradouro()
                        + "&numero=" + a.getEndereco().getNumero()
                        + "&cidade=" + a.getEndereco().getCidade()
                        + "&uf=" + a.getEndereco().getEstado()
                        + "&bairro=" + a.getEndereco().getBairro()
                        + "&cep=" + a.getEndereco().getCep()
                        + "&id_endereco=" + a.getEndereco().getId()
                        + "'>Editar</a>\","
                        + "\"<a href='/sisescola/Professor?operacao=EXCLUIR"
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