//Classe responsável por gerenciar os itens do menu de delivery.
//Encapsula os dados (nome e preço) dos itens e fornece métodos para acessar esses dados.

package model;

public class Delivery {
    private final String nome;
    private final double preco;

    public Delivery(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}