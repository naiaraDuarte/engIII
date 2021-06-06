
package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Professor;


public class Teste {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setNome("Pedro");
        professor.setCpf("123456789");
        ProfessorDAO professorDao = new ProfessorDAO();
        professorDao.salvar(professor);
        
    }
}
