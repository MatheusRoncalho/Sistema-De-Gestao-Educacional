package ProjetoEduConnect.model;

import java.util.Objects;

public abstract class Usuario implements Autenticacao {
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        Objects.requireNonNull(nome, "Nome inválido");
        Objects.requireNonNull(login, "Login inválido");
        Objects.requireNonNull(senha, "Senha inválida");
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public void autenticar(String login, String senha) {}

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }
}
