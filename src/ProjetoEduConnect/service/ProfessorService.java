package ProjetoEduConnect.service;

import ProjetoEduConnect.model.Professor;
import ProjetoEduConnect.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {
    private ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrarProfessor(String nome, String especialidade, String registro, String login, String senha) {
        if (professorRepository.listarProfessores().stream().anyMatch(professor -> professor.getRegistro().equals(registro))) {
            throw new IllegalArgumentException("Registro ja cadastrado");
        }
        Professor professor = new Professor(nome, especialidade, registro, login, senha);
        professorRepository.salvarProfessor(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public Professor buscarRegistro(String registro) {
        for (Professor professor : professorRepository.listarProfessores()) {
            if (professor.getRegistro().equals(registro)) {
                return professor;
            }
        }
        throw new IllegalArgumentException("Registro não encontrado. Cadastre o professor primeiro!");
    }

    public List<Professor> listar() {
        return professorRepository.listarProfessores();
    }
}
