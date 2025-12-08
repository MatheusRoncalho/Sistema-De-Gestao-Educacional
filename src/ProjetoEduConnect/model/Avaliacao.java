package ProjetoEduConnect.model;

import java.util.Objects;

public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao) {
        Objects.requireNonNull(descricao, "Descrição inválida.");
        this.descricao = descricao;
    }

    public void atribuirNota(double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("Número invalido. Deve ser entre 0 e 10");
        }
        this.nota = valor;
    }

    @Override
    public String toString() {
        return "descricao: "+descricao+", nota: "+nota+" | ";
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }
}
