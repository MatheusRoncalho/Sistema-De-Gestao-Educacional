package ProjetoEduConnect.repository;

import ProjetoEduConnect.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();

    public void salvarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> listarCursos() {
        return cursos;
    }
}
