package br.edu.instituicao.factory;

import br.edu.instituicao.model.Coordenador;
import br.edu.instituicao.model.Pessoa;

public class CoordenadorFactory implements PessoaFactory {
    @Override
    public Pessoa criarPessoa(String nome, String cpf, String email, String[] extras) {
        String siape = extras[0];
        String senha = extras[1];
        return new Coordenador(nome, cpf, email, siape, senha);
    }
}
