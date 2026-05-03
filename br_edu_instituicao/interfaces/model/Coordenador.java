package br.edu.instituicao.model;

public class Coordenador extends Professor {

    private static final int BONUS_HORAS = 10;

    public Coordenador(String nome, String cpf, String email, String siape, String senha) {
        super(nome, cpf, email, siape, senha );

    }

    @Override

    public int getHorasAtivide() {
        return super.getHorasAtivide() + BONUS_HORAS;
    }
}