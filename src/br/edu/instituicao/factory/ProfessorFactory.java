package br.edu.instituicao.factory;

import br.edu.instituicao.model.Pessoa;
import br.edu.instituicao.model.Professor;


public class ProfessorFactory implements PessoaFactory {

    @Override
    public Pessoa criarPessoa(String nome, String cpf, String email, String[] extras) {
        String siape = extras[0];
        String senha = extras[1];
        return new Professor(nome, cpf, email, siape, senha);
    }
}
