package view;

import controller.Menu;
import util.Util;

import java.util.List;

public class MenuDelivery extends Menu {

    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("MENU DELIVERY", List.of("Pizzas", "Lanches", "Doces", "Voltar"));

        int opcaoSelecionada = 0;
        do {
            System.out.println(menu);
            opcaoSelecionada = entrada.nextInt();
            switch (opcaoSelecionada) {
                case 1:
                    exibirSubmenu("Pizzas", List.of(
                            new Item("Moda da casa", 60.00),
                            new Item("Frango com catupiry", 55.00),
                            new Item("Marguerita", 50.00)
                    ));
                    break;

                case 2:
                    exibirSubmenu("Lanches", List.of(
                            new Item("Hamburguer artesanal", 30.00),
                            new Item("Pastel misto", 6.00),
                            new Item("Coxinha de frango", 4.00)
                    ));
                    break;

                case 3:
                    exibirSubmenu("Doces", List.of(
                            new Item("Bolo de cenoura", 6.00),
                            new Item("Pão de mel", 4.00),
                            new Item("Donuts de chocolate", 7.00)
                    ));
                    break;

                case 4:
                    return;

                default:
                    Util.erro("Opção inválida!");
                    break;
            }
        } while (opcaoSelecionada != 4);
    }

    private void exibirSubmenu(String categoria, List<Item> itens) {
        String menu = Menu.geraMenuComOpcoes("MENU " + categoria.toUpperCase(), itens.stream().map(Item::getNome).toList());

        int opcaoSelecionada = 0;
        do {
            System.out.println(menu);
            opcaoSelecionada = entrada.nextInt();
            if (opcaoSelecionada > 0 && opcaoSelecionada <= itens.size()) {
                Item item = itens.get(opcaoSelecionada - 1);
                exibirItem(item.getNome(), item.getPreco());
            } else {
                Util.erro("Opção inválida!");
            }
        } while (opcaoSelecionada < 1 || opcaoSelecionada > itens.size());
    }

    private void exibirItem(String item, double preco) {
        System.out.println("Você escolheu: " + item);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Deseja confirmar o pedido? (1- Sim, 2- Não)");

        int confirmacao = entrada.nextInt();
        if (confirmacao == 1) {
            System.out.println("Pedido confirmado! O restaurante está preparando o seu pedido...");
            System.out.println("Aguarde a entrega. Obrigado pela preferência! (:");
        } else {
            System.out.println("Pedido cancelado.");
        }
    }

    private static class Item {
        private final String nome;
        private final double preco;

        public Item(String nome, double preco) {
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
}