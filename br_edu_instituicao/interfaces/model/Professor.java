package br.edu.instituicao.model;


import br.edu.instituicao.interfaces.Autenticavel {

    public class Professor extends Pessoa implements Autenticavel {

        private String siape;
        private String senha;

    }

    @Override
    public boolean login(String senha) { return this.senha.equals(senha); }

    public int getHorasAtivide(){ return 20;}

    public String getSiape() { return siape; }
    public void setSiape(String siape) {this.siape = siape; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override

    public String toString() {
        return super.toString() + " | SIAPE: " + siape + "| Horas de Atividade: " + getHorasAtivide() + "h";
    }
}