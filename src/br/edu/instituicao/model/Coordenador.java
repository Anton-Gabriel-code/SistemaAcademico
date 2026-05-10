package br.edu.instituicao.model;

public class Coordenador extends Professor {

    private static final int BONUS_HORAS = 10;

    public Coordenador(String nome, String cpf, String email, String siape, String senha) {
        super(nome, cpf, email, siape, senha);
    }

    @Override
    public int getHorasAtividade() {
        return super.getHorasAtividade() + BONUS_HORAS;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
