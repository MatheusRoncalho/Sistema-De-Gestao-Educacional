package ProjetoEduConnect.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno extends Usuario  implements GerarRelatorio {
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacaos = new ArrayList<>();


    public Aluno(String nome, String matricula, Curso curso, String login, String senha) {
        super(nome, login, senha);
        Objects.requireNonNull(matricula, "A matricula do aluno não pode ser vazia");
        Objects.requireNonNull(curso, "O curso do aluno não pode ser vazio");
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void autenticar(String login, String senha) {
        if (this.login.equals(login) && this.senha.equals(senha)) {
            System.out.println("Aluno autenticado");
        }else {
            System.out.println("Login ou senha inválidos");
        }
    }

    public void salvarAvaliacoes(Avaliacao avaliacao) {
        avaliacaos.add(avaliacao);
        System.out.println("Avaliação registrada com sucesso!");
    }

    @Override
    public void gerarRelatorio() {
        System.out.print("Nome: "+nome+"\ncurso = "+curso+"\nAvaliações = ");
        for (Avaliacao avaliacao : avaliacaos) {
            System.out.print(avaliacao);
        }
        System.out.println("\n---------------------------");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
