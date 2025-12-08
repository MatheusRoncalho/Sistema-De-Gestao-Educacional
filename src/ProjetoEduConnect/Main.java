package ProjetoEduConnect;

import ProjetoEduConnect.repository.*;
import ProjetoEduConnect.service.*;
import ProjetoEduConnect.ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        AlunoRepository alunoRepository = new AlunoRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();
        CursoRepository cursoRepository = new CursoRepository();
        TurmaRepository turmaRepository = new TurmaRepository();

        AlunoService alunoService = new AlunoService(alunoRepository);
        ProfessorService professorService = new ProfessorService(professorRepository);
        CursoService cursoService = new CursoService(cursoRepository);
        TurmaService turmaService = new TurmaService(turmaRepository);

        MenuInterativo menu = new MenuInterativo(alunoService, professorService, cursoService, turmaService);
        menu.iniciar();
    }
}
