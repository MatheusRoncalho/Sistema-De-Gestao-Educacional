package ProjetoEduConnect.model;

import java.util.Objects;

public class Curso implements GerarRelatorio {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        Objects.requireNonNull(nome, "O nome do curso não pode ser vazio");
        Objects.requireNonNull(codigo, "O codigo do curso não pode ser vazio");
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("A carga horaria deve ser maior que 0");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Curso: "+nome+ ", codigo: "+codigo+", carga horaria: "+cargaHoraria);
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cargaHoraria=" + cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
