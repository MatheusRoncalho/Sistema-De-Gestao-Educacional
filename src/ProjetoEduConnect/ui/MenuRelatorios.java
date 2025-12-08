package ProjetoEduConnect.ui;

import ProjetoEduConnect.model.Aluno;
import ProjetoEduConnect.model.Curso;
import ProjetoEduConnect.model.GerarRelatorio;
import ProjetoEduConnect.model.Professor;

import java.util.List;
import java.util.Scanner;

public class MenuRelatorios {
    public void iniciarRelatorios(List<Aluno> alunos, List<Professor> professores, List<Curso> cursos) {
        if (alunos.isEmpty()) {
            throw new IllegalArgumentException("Cadastre um aluno primeiro");
        } else if (professores.isEmpty()) {
            throw new IllegalArgumentException("Cadastre um professor primeiro");

        } else if (cursos.isEmpty()) {
            throw new IllegalArgumentException("Cadastre um curso primeiro");
        }
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- Menu de Relatórios -----");
            System.out.println("1 - Relatórios de Alunos");
            System.out.println("2 - Relatórios de Professores");
            System.out.println("3 - Relatórios de Cursos");
            System.out.println("4 - Relatórios de TODOS");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerarRelatorios(alunos);
                    break;
                case 2:
                    gerarRelatorios(professores);
                    break;
                case 3:
                    gerarRelatorios(cursos);
                    break;
                case 4:
                    gerarRelatorios(alunos);
                    gerarRelatorios(professores);
                    gerarRelatorios(cursos);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 0);
    }

    private void gerarRelatorios(List<? extends GerarRelatorio> lista) {
        if (lista.getFirst() instanceof Aluno) {
            System.out.println("----- Relatório Alunos -----");
        } else if (lista.getFirst() instanceof Professor) {
            System.out.println("----- Relatório Professores -----");
        } else if (lista.getFirst() instanceof Curso) {
            System.out.println("----- Relatório Cursos -----");
        }
        for (GerarRelatorio relatorio : lista) {
            relatorio.gerarRelatorio();
        }
    }
}