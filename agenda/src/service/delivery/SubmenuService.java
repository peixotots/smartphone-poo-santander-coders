//Classe responsável por exibir os submenus específicos de cada categoria do delivery

package service.delivery;

import menu.Menu;
import model.Delivery;
import util.Util;

import java.util.List;
import java.util.Scanner;

public class SubmenuService {

    public static void exibirSubmenu(String categoria, List<Delivery> itens) {
        String menu = Menu.geraMenuComOpcoes("MENU " + categoria.toUpperCase(), itens.stream().map(Delivery::getNome).toList());

        int opcaoSelecionada;
        do {
            System.out.println(menu);
            opcaoSelecionada = new Scanner(System.in).nextInt();
            if (opcaoSelecionada > 0 && opcaoSelecionada <= itens.size()) {
                Delivery delivery = itens.get(opcaoSelecionada - 1);
                PedidoService.exibirItem(delivery.getNome(), delivery.getPreco());
            } else {
                Util.erro("Opção inválida!");
            }
        } while (opcaoSelecionada < 1 || opcaoSelecionada > itens.size());
    }
}