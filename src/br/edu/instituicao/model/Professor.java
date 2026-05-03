package br.edu.instituicao.model;

import br.edu.instituicao.interfaces.Autenticavel;

public class Professor extends Pessoa implements Autenticavel {

    private String siape;
    private String senha;

    public Professor(String nome, String cpf, String email, String siape, String senha) {
        super(nome, cpf, email);
        this.siape = siape;
        this.senha = senha;
    }

    @Override
    public boolean login(String senha) {
        return this.senha.equals(senha);
    }

    public int getHorasAtividade() {
        return 20; // Professor comum: 20h
    }

    // Getters e Setters
    public String getSiape() { return siape; }
    public void setSiape(String siape) { this.siape = siape; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public String toString() {
        return super.toString() + " | SIAPE: " + siape
                + " | Horas de atividade: " + getHorasAtividade() + "h";
    }
}
