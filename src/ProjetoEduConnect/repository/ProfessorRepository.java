package ProjetoEduConnect.repository;

import ProjetoEduConnect.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();

    public void salvarProfessor(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> listarProfessores() {
        return professores;
    }
}
