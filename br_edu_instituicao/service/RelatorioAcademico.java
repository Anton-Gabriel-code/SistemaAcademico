package br.edu.instituicao.service;

import br.edu.instituicao.interfaces.Avaliavel;
import java.util.ArrayList;


public class RelatorioAcdemico {

    private ArrayList<Avaliavel> avaliados;

    public RelatorioAcdemico() {
        this.avaliados = new ArrayList<>();
    }

    public void adicionarDados(Avaliavel objeto) {
        avaliados.add(objeto);
    }

    public void exibirMediaGeral() {
        if (avaliados.isEmpty()) {
            System.out.println("Nenhum dado foi inserido no relátorio.");
            return;
        }

        double somaMedias = 0;
        for (Avaliavel a : avaliados) { somaMedias += a.getMediaFinal()};

        double mediaGeral = somaMedias / avaliados.size();
        System.out.println("-------------------------------------------------");
        System.out.println("-------------RELATÓRIO ACADÊMICO-----------------");
        System.out.println("-------------------------------------------------");
        System.out.printf(" Total de alunos avaliados %d%n", avaliados.size());
        System.out.printf(" Média Geral da INstituição: %2f%n", mediaGeral);
        System.out.println("-------------------------------------------------");
    }

}