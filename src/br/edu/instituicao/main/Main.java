package br.edu.instituicao.main;

import br.edu.instituicao.factory.AlunoFactory;
import br.edu.instituicao.factory.CoordenadorFactory;
import br.edu.instituicao.factory.PessoaFactory;
import br.edu.instituicao.factory.ProfessorFactory;
import br.edu.instituicao.model.Aluno;
import br.edu.instituicao.model.Pessoa;
import br.edu.instituicao.model.Professor;
import br.edu.instituicao.service.RelatorioAcademico;
import br.edu.instituicao.service.Secretaria;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Secretaria secretaria = Secretaria.getInstance();

    static RelatorioAcademico relatorio = new RelatorioAcademico();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> cadastrarProfessor();
                case 3 -> lancarNotas();
                case 4 -> secretaria.listarMembros();
                case 5 -> exibirEstatisticas();
                case 6 -> acessoAdministrativo();
                case 7 -> System.out.println("Encerrando o sistema. Ate logo!");
                default -> System.out.println("Opcao invalida! Tente novamente.");
            }

        } while (opcao != 7);

        scanner.close();
    }

    static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("     SISTEMA ACADEMICO - MENU           ");
        System.out.println("========================================");
        System.out.println("  1. Cadastrar Aluno");
        System.out.println("  2. Cadastrar Professor / Coordenador");
        System.out.println("  3. Lancar Notas de Aluno");
        System.out.println("  4. Listar Comunidade Academica");
        System.out.println("  5. Exibir Estatisticas (Media Geral)");
        System.out.println("  6. Acesso Administrativo (Login)");
        System.out.println("  7. Sair");
        System.out.println("========================================");
    }

    static void cadastrarAluno() {
        System.out.println("\n--- CADASTRAR ALUNO ---");
        String nome = lerString("Nome: ");
        String cpf = lerString("CPF: ");
        String email = lerString("Email: ");
        String matricula = lerString("Matricula: ");

        PessoaFactory factory = new AlunoFactory();
        Aluno aluno = (Aluno) factory.criarPessoa(nome, cpf, email, new String[]{matricula});

        secretaria.cadastrarAluno(aluno);
        relatorio.adicionarDados(aluno);
    }

    static void cadastrarProfessor() {
        System.out.println("\n--- CADASTRAR PROFESSOR / COORDENADOR ---");
        System.out.println("Tipo: 1 - Professor  |  2 - Coordenador");
        int tipo = lerInt("Escolha: ");

        String nome = lerString("Nome: ");
        String cpf = lerString("CPF: ");
        String email = lerString("Email: ");
        String siape = lerString("SIAPE: ");
        String senha = lerString("Senha: ");
        
        PessoaFactory factory;
        if (tipo == 2) {
            factory = new CoordenadorFactory();
        } else {
            factory = new ProfessorFactory();
        }

        Professor prof = (Professor) factory.criarPessoa(nome, cpf, email, new String[]{siape, senha});
        secretaria.cadastrarProfessor(prof);
    }

    static void lancarNotas() {
        System.out.println("\n--- LANCAR NOTAS ---");
        String busca = lerString("Digite matricula ou nome do aluno: ");
        Aluno aluno = secretaria.buscarAluno(busca);

        if (aluno == null) {
            System.out.println("Aluno nao encontrado!");
            return;
        }

        System.out.println("Aluno encontrado: " + aluno.getNome());
        int qtd = lerInt("Quantas notas deseja lancar? ");

        for (int i = 1; i <= qtd; i++) {
            double nota = lerDouble("Nota " + i + " (0-10): ");
            aluno.adicionarNota(nota);
        }
    }

    static void exibirEstatisticas() {
        System.out.println("\n--- ESTATISTICAS ---");
        relatorio.exibirMediaGeral();
    }

    static void acessoAdministrativo() {
        System.out.println("\n--- ACESSO ADMINISTRATIVO ---");
        String siape = lerString("SIAPE do professor/coordenador: ");
        String senha = lerString("Senha: ");

        boolean encontrado = false;
        for (Pessoa p : secretaria.getMembros()) {
            if (p instanceof Professor prof) {
                if (prof.getSiape().equals(siape)) {
                    encontrado = true;
                    if (prof.login(senha)) {
                        System.out.println("Login realizado com sucesso! Bem-vindo(a), " + prof.getNome() + ".");
                        System.out.println("Tipo: " + prof.getClass().getSimpleName()
                                + " | Horas de atividade: " + prof.getHorasAtividade() + "h");
                    } else {
                        System.out.println("Senha incorreta!");
                    }
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum professor/coordenador encontrado com esse SIAPE.");
        }
    }

    static String lerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    static int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro.");
            }
        }
    }

    static double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero decimal.");
            }
        }
    }
}
