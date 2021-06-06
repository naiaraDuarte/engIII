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
public class ValidarMatriculaAluno implements IStrategy{

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validarMatriculaAluno = false;
        
        if(validarMatriculaAluno)
            return "Um mesmo aluno não pode estar matriculado no mesmo curso em mais de uma turma.";
        
        return null;    
    }
    
}
