package ProjetoEduConnect.ui;

import ProjetoEduConnect.model.*;
import ProjetoEduConnect.service.AlunoService;
import ProjetoEduConnect.service.CursoService;
import ProjetoEduConnect.service.ProfessorService;
import ProjetoEduConnect.service.TurmaService;

import java.util.Scanner;

public class MenuInterativo {
    private AlunoService alunoService;
    private ProfessorService professorService;
    private CursoService cursoService;
    private TurmaService turmaService;

    public MenuInterativo(AlunoService alunoService, ProfessorService professorService,
                          CursoService cursoService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.turmaService = turmaService;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("----- Menu Principal -----");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Cadastrar professor");
            System.out.println("3 - Cadastrar aluno");
            System.out.println("4 - Criar turma");
            System.out.println("5 - Matricular Aluno em Turma");
            System.out.println("6 - Registrar Avaliação de aluno");
            System.out.println("7 - Gerar Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o nome do curso: ");
                    String nomeCurso = scanner.nextLine();
                    System.out.print("Digite o Código do curso (ex ADS-001): ");
                    String codigoCurso = scanner.nextLine();
                    System.out.print("Digite a carga horária: ");
                    int cargaHoraria = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a modalidade (1-EAD, 2-Presencial): ");
                    String tipo = scanner.nextLine();
                    if ("1".equals(tipo)) {
                        System.out.print("Plataforma: ");
                        String plataforma = scanner.nextLine();
                        try {
                            cursoService.cadastrarCursoEAD(nomeCurso, codigoCurso, cargaHoraria, plataforma);
                            System.out.println("Curso cadastrado com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: "+e.getMessage());
                        }
                    } else {
                        System.out.print("Sala: ");
                        String sala = scanner.nextLine();
                        try {
                            cursoService.cadastrarCursoPresencial(nomeCurso, codigoCurso, cargaHoraria, sala);
                            System.out.println("Curso cadastrado com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: "+e.getMessage());
                        }
                    }
                    break;
                case "2":
                    System.out.print("Digite o nome do professor: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("Digite a especialidade: ");
                    String especialidade = scanner.nextLine();
                    System.out.print("Digite o registro: ");
                    String registro = scanner.nextLine();
                    System.out.print("Digite o login: ");
                    String loginProfessor = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String senhaProfessor = scanner.nextLine();
                    try {
                        professorService.cadastrarProfessor(nomeProfessor, especialidade, registro, loginProfessor, senhaProfessor);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Digite a matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Digite o código do curso: ");
                    String codigoCursoAluno = scanner.nextLine();
                    try {
                        Curso cursoAluno = cursoService.buscarCodigo(codigoCursoAluno);
                        System.out.print("Digite o login: ");
                        String loginAluno = scanner.nextLine();
                        System.out.print("Digite a senha: ");
                        String senhaAluno = scanner.nextLine();
                        try {
                            alunoService.cadastrarAluno(nomeAluno, matricula, cursoAluno, loginAluno, senhaAluno);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: "+e.getMessage());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case "4":
                    System.out.print("Digite o código da turma: ");
                    String codigoTurma = scanner.nextLine();
                    System.out.print("Digite o registro do professor: ");
                    String registroProfessor = scanner.nextLine();
                    try {
                        Professor professorTurma = professorService.buscarRegistro(registroProfessor);
                        System.out.print("Digite o código do curso: ");
                        String codigoCursoTurma = scanner.nextLine();
                        try {
                            Curso cursoTurma = cursoService.buscarCodigo(codigoCursoTurma);
                            turmaService.criarTurma(codigoTurma, professorTurma, cursoTurma);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: "+e.getMessage());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case "5":
                    System.out.print("Digite o código da turma que deseja matricular o aluno: ");
                    String codigoTurmaMatricular = scanner.nextLine();
                    try {
                        Turma turma = turmaService.buscarTurma(codigoTurmaMatricular);
                        System.out.print("Digite a matricula do aluno que deseja matricular: ");
                        String matriculaAluno = scanner.nextLine();
                        try {
                            Aluno aluno = alunoService.buscarMatricula(matriculaAluno);
                            turma.adicionarAlunoNaTurma(aluno);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: "+e.getMessage());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case "6":
                    System.out.print("Digite o código da turma que está o aluno: ");
                    String codigoTurmaAluno = scanner.nextLine();
                    try {
                        Turma turmaAluno = turmaService.buscarTurma(codigoTurmaAluno);
                        System.out.print("Digite a matricula do aluno: ");
                        String matriculaAlunoTurma = scanner.nextLine();
                        try {
                            turmaAluno.buscarMatriculaNaTurma(matriculaAlunoTurma);
                            System.out.print("Digite a descrição da prova: ");
                            String descricao = scanner.nextLine();
                            Avaliacao avaliacao = new Avaliacao(descricao);
                            System.out.print("Digite a nota da avaliação: ");
                            int nota = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                avaliacao.atribuirNota(nota);
                                turmaAluno.registrarAvaliacao(matriculaAlunoTurma, avaliacao);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Erro: "+e.getMessage());
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: "+e.getMessage());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case "7":
                    MenuRelatorios menuRelatorios = new MenuRelatorios();
                    try {
                        menuRelatorios.iniciarRelatorios(alunoService.listar(), professorService.listar(), cursoService.listar());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (!opcao.equals("0"));
    }
}
