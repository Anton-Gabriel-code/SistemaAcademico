package br.edu.instituicao.factory;

import br.edu.instituicao.model.Pessoa;

public interface PessoaFactory {
    Pessoa criarPessoa(String nome, String cpf, String email, String[] extras);
}
