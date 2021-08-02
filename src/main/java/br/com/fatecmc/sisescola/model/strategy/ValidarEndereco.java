package br.com.fatecmc.sisescola.model.strategy;

import br.com.fatecmc.sisescola.model.domain.Endereco;
import br.com.fatecmc.sisescola.model.domain.EntidadeDominio;

public class ValidarEndereco implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        if (entidade instanceof Endereco) {
            Endereco endereco = (Endereco) entidade;

            String cidade = endereco.getCidade();
            String logradouro = endereco.getLogradouro();
            String estado = endereco.getEstado();
            String nr = endereco.getNumero();
            String cep = endereco.getCep();

            if (logradouro == null || cidade == null || estado == null || nr == null || cep == null) {
                return " O endereço deve estar completo!";
            } else if (logradouro.trim().equals("") || cidade.trim().equals("") || estado.trim().equals("")
                    || nr.trim().equals("")) {
                return " O endereço deve estar completo!";
            } else if (cep.length() != 9) {
                return " CEP deve ser valido!";
            }

        } else {
            return " Deve ser registrado um endereco!";
        }

        return null;
    }

}
