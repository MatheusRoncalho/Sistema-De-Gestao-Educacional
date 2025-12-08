package ProjetoEduConnect.service;

import ProjetoEduConnect.model.Aluno;
import ProjetoEduConnect.model.Curso;
import ProjetoEduConnect.repository.AlunoRepository;

import java.util.List;

public class AlunoService{

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void cadastrarAluno(String nome, String matricula, Curso curso, String login, String senha) {
        if (alunoRepository.listarAlunos().stream().anyMatch(aluno -> aluno.getMatricula().equals(matricula))) {
            throw new IllegalArgumentException("Matricula ja cadastrada");
        }
        Aluno aluno = new Aluno(nome, matricula, curso, login, senha);
        alunoRepository.salvarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public List<Aluno> listar() {
        return alunoRepository.listarAlunos();
    }

    public Aluno buscarMatricula(String matricula) {
        for (Aluno aluno : alunoRepository.listarAlunos()) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        throw new IllegalArgumentException("Aluno não encontrado. Cadastre o aluno primeiro");
    }
}
