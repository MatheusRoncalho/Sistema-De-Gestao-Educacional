package ProjetoEduConnect.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> alunos = new ArrayList<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        Objects.requireNonNull(codigo, "O codigo não pode ser vazio");
        Objects.requireNonNull(professor, "Deve ter um professor para a turma");
        Objects.requireNonNull(curso, "Deve ter o curso da turma");
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public void adicionarAlunoNaTurma(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado na turma com sucesso!");
    }

    public void removerAlunoDaTurma(String aluno) {
        alunos.removeIf(aluno1 -> aluno1.getNome().equals(aluno));
        System.out.println("Aluno removido da turma com sucesso!");
    }

    public void registrarAvaliacao(String matricula, Avaliacao avaliacao) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)){
                aluno.salvarAvaliacoes(avaliacao);
            }
        }
    }

    public void buscarMatriculaNaTurma(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return;
            }
        }
        throw new IllegalArgumentException("Aluno não encontrado na turma. Cadastre o aluno na turma primeiro");
    }

    @Override
    public String toString() {
        return "Turma{" +
                "codigo='" + codigo + '\'' +
                ", professor=" + professor +
                ", curso=" + curso +
                ", alunos=" + alunos +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
