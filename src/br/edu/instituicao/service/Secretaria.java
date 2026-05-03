package br.edu.instituicao.service;

import br.edu.instituicao.model.Aluno;
import br.edu.instituicao.model.Pessoa;
import br.edu.instituicao.model.Professor;

import java.util.ArrayList;

public class Secretaria {

    private ArrayList<Pessoa> membros;

    public Secretaria() {
        this.membros = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        membros.add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " cadastrado com sucesso!");
    }

    public void cadastrarProfessor(Professor professor) {
        membros.add(professor);
        System.out.println("Professor " + professor.getNome() + " cadastrado com sucesso!");
    }

    public void listarMembros() {
        if (membros.isEmpty()) {
            System.out.println("Nenhum membro cadastrado.");
            return;
        }
        System.out.println("========================================");
        System.out.println("       COMUNIDADE ACADÊMICA             ");
        System.out.println("========================================");
        for (Pessoa p : membros) {
            System.out.println(p);
        }
        System.out.println("========================================");
    }

    public Aluno buscarAluno(String busca) {
        for (Pessoa p : membros) {
            if (p instanceof Aluno) {
                Aluno a = (Aluno) p;
                if (a.getMatricula().equalsIgnoreCase(busca)
                        || a.getNome().equalsIgnoreCase(busca)) {
                    return a;
                }
            }
        }
        return null;
    }

    public ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (Pessoa p : membros) {
            if (p instanceof Aluno) alunos.add((Aluno) p);
        }
        return alunos;
    }

    public ArrayList<Pessoa> getMembros() {
        return membros;
    }
}
