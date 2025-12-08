package ProjetoEduConnect.model;

import java.util.Objects;

public class Professor extends Usuario implements GerarRelatorio {
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro, String login, String senha) {
        super(nome, login, senha);
        Objects.requireNonNull(especialidade, "A especialidade do professor não pode ser vazia");
        Objects.requireNonNull(registro, "O registro do professor não pode ser vazio");
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Nome: "+nome+ " | Especialidade: "+especialidade+" | Registro: "+registro);
        System.out.println("---------------------------");
    }

    @Override
    public void autenticar(String login, String senha) {
        if (this.login.equals(login) && this.senha.equals(senha)) {
            System.out.println("Professor autenticado");
        }else {
            System.out.println("Login ou senha inválidos");
        }
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", registro='" + registro + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
