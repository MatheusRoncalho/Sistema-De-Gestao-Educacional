package ProjetoEduConnect.model;

import java.util.Objects;

public class CursoEAD extends Curso{
    private String plataforma;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        super(nome, codigo, cargaHoraria);
        Objects.requireNonNull(plataforma,"Plataforma inválida");
        this.plataforma = plataforma;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Curso: "+getNome()+" | Código: "+getCodigo()+
                " | Carga horária: "+getCargaHoraria()+"h"+ " | Modalidade: EAD | Plataforma "+plataforma);
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        return "Curso: "+getNome()+" | Código: "+getCodigo()+
                " | Carga horária: "+getCargaHoraria()+"h"+ " | Modalidade: EAD | Plataforma "+plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }
}
