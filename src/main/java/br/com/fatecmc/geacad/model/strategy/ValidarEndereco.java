package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.Endereco;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

public class ValidarEndereco implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        if (entidade instanceof Endereco) {
            Endereco endereco = (Endereco) entidade;

            String cidade = endereco.getCidade();
            String logradouro = endereco.getLogradouro();
            String estado = endereco.getEstado();
            String nr = endereco.getNumero();

            if (logradouro == null || cidade == null || estado == null || nr == null) {
                return "O endereço deve estar completo!";
            } else if (logradouro.trim().equals("") || cidade.trim().equals("") || estado.trim().equals("")
                    || nr.trim().equals("")) {
                return "O endereço deve estar completo!";
            }

        } else {
            return "Deve ser registrado um endereco!";
        }

        return null;
    }

}
