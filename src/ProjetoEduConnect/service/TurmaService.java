package ProjetoEduConnect.service;

import ProjetoEduConnect.model.Curso;
import ProjetoEduConnect.model.Professor;
import ProjetoEduConnect.model.Turma;
import ProjetoEduConnect.repository.TurmaRepository;

public class TurmaService {
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public void criarTurma(String codigo, Professor professor, Curso curso) {
        if (turmaRepository.listarTurmas().stream().anyMatch(turma -> turma.getCodigo().equals(codigo))) {
            throw new IllegalArgumentException("Turma ja cadastrada");
        }
        Turma turma = new Turma(codigo, professor, curso);
        turmaRepository.salvarTurma(turma);
    }

    public Turma buscarTurma(String codigo) {
        for (Turma turma : turmaRepository.listarTurmas()) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        throw new IllegalArgumentException("Código da turma não encontrado. Cadastre a turma primeiro!");
    }
}
