package ProjetoEduConnect.repository;

import ProjetoEduConnect.model.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private List<Turma> turmas = new ArrayList<>();

    public void salvarTurma(Turma turma) {
        turmas.add(turma);
        System.out.println("Turma criada com sucesso");
    }

    public List<Turma> listarTurmas() {
        return turmas;
    }
}
