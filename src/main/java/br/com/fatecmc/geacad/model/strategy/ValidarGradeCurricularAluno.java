/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

/**
 *
 * @author teste
 */
public class ValidarGradeCurricularAluno implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean ValidarGradeCurricularAluno = false;
        
        if(ValidarGradeCurricularAluno)
            return "O aluno só pode se cadastrar em matérias que estão dentro da sua grade curricular";
        
        return null;
    }
    
}
