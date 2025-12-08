package ProjetoEduConnect.service;

import ProjetoEduConnect.model.Curso;
import ProjetoEduConnect.model.CursoEAD;
import ProjetoEduConnect.model.CursoPresencial;
import ProjetoEduConnect.repository.CursoRepository;

import java.util.List;

public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void cadastrarCursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        if (cursoRepository.listarCursos().stream().anyMatch(curso -> curso.getCodigo().equals(codigo))) {
            throw new IllegalArgumentException("Código já cadastrado");
        }
        Curso curso = new CursoEAD(nome, codigo, cargaHoraria, plataforma);
        cursoRepository.salvarCurso(curso);
    }

    public void cadastrarCursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        if (cursoRepository.listarCursos().stream().anyMatch(curso -> curso.getCodigo().equals(codigo))) {
            throw new IllegalArgumentException("Código já cadastrado");
        }
        Curso curso = new CursoPresencial(nome, codigo, cargaHoraria, sala);
        cursoRepository.salvarCurso(curso);
    }

    public Curso buscarCodigo(String codigo) {
        for (Curso curso : cursoRepository.listarCursos()) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        throw new IllegalArgumentException("Código não encontrado. Cadastre o curso primeiro");
    }

    public List<Curso> listar() {
        return cursoRepository.listarCursos();
    }
}
