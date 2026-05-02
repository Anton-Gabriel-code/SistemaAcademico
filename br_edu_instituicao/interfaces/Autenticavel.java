package br.edu.instituicao.interfaces;


public interface Autenticavel {
    boolean login(String senha);
}

// Classe que conterá o método login e outros arquivos que implemnetarem precisam ter o método login(), para que possa acessar