package br.edu.instituicao.model;


import br.edu.instituicao.interfaces.Avaliavel;

import java.util.ArrayList;

public class Aluno extends Pessoa implements Avaliavel{

    private String matricla;
    private ArrayList <Double> notas;


    public Aluno(String nome, String cpf, String email, String matricula) {

        super(nome, cpf, email);
        this.matricula = matricula;
        this.notas = new ArrayList<>();
    }

    public void adicionarNota(double nota) {

        if(nota < 0 || nota > 10) {
            System.out.println("Nota inserida inválida!! Dever ser uma nota entre 0 e 10.");
            return;
        }

        notas.add(nota);
        System.out.println("Nota" + nota + "do aluno" + getNome() + "" + "adicionada ao sistema.");
    }



    @Override

    public double detMediaFinal() {
        if(nota.isEmpty()) return 0.0;
        double soma = 0

        for (double nota : notas) soma += nota;
        return soma / notas.size();
    }


    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }


    public ArrayList <Double> getNotas() { return notas; }
    public void setNotas(ArrayList <Double> notas) { this.notas = notas; }



    @Override

    public String toString(){
        return super.toString() + " | Matrícula: "  + matricula + " | Média: " + String.format("%.2f", getMediaFinal());
    }
}