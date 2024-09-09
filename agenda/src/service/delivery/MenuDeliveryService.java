//Classe responsável por gerenciar o menu principal de delivery
//Herda da classe Menu e implementa o metodo do 'selecionaOpcao' para exibir e processar as opções do menu de delivery

package service.delivery;

import controller.Menu;
import util.Util;

import java.util.List;

public class MenuDeliveryService extends Menu {

    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("MENU DELIVERY", List.of("Pizzas", "Lanches", "Doces", "Voltar"));

        int opcaoSelecionada = 0;
        do {
            System.out.println(menu);
            opcaoSelecionada = entrada.nextInt();
            switch (opcaoSelecionada) {
                case 1:
                    SubmenuService.exibirSubmenu("Pizzas", List.of(
                            new ItemService("Moda da casa", 60.00),
                            new ItemService("Frango com catupiry", 55.00),
                            new ItemService("Marguerita", 50.00)
                    ));
                    break;

                case 2:
                    SubmenuService.exibirSubmenu("Hamburguer", List.of(
                            new ItemService("Smash com fritas", 38.00),
                            new ItemService("Frango com salada", 32.00),
                            new ItemService("Vegetariano (burguer de soja)", 34.00)
                    ));
                    break;

                case 3:
                    SubmenuService.exibirSubmenu("Doces", List.of(
                            new ItemService("Bolo de cenoura", 8.00),
                            new ItemService("Pão de mel", 6.00),
                            new ItemService("Donuts de chocolate", 12.00)
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
}