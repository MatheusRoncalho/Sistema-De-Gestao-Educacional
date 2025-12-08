package ProjetoEduConnect.model;

import java.util.Objects;

public class CursoPresencial extends Curso{
    private String sala;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        super(nome, codigo, cargaHoraria);
        Objects.requireNonNull(sala,"Plataforma inválida");
        this.sala = sala;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Curso: "+getNome()+" | Código: "+getCodigo()+
                " | Carga horária: "+getCargaHoraria()+"h"+ " | Modalidade: Presencial | Sala "+sala);
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        return "Curso: "+getNome()+" | Código: "+getCodigo()+
                " | Carga horária: "+getCargaHoraria()+"h"+ " | Modalidade: Presencial | Sala "+sala;
    }

    public String getSala() {
        return sala;
    }
}
