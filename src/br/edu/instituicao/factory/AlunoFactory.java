package br.edu.instituicao.factory;

import br.edu.instituicao.model.Aluno;
import br.edu.instituicao.model.Pessoa;

public class AlunoFactory implements PessoaFactory {

    @Override
    public Pessoa criarPessoa(String nome, String cpf, String email, String[] extras) {
        String matricula = extras[0];
        return new Aluno(nome, cpf, email, matricula);
    }
}
