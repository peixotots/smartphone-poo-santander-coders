//Classe responsável por exibir os submenus específicos de cada categoria do delivery

package service.delivery;

import controller.Menu;
import util.Util;

import java.util.List;
import java.util.Scanner;

public class SubmenuService {

    public static void exibirSubmenu(String categoria, List<ItemService> itens) {
        String menu = Menu.geraMenuComOpcoes("MENU " + categoria.toUpperCase(), itens.stream().map(ItemService::getNome).toList());

        int opcaoSelecionada = 0;
        do {
            System.out.println(menu);
            opcaoSelecionada = new Scanner(System.in).nextInt();
            if (opcaoSelecionada > 0 && opcaoSelecionada <= itens.size()) {
                ItemService itemService = itens.get(opcaoSelecionada - 1);
                PedidoService.exibirItem(itemService.getNome(), itemService.getPreco());
            } else {
                Util.erro("Opção inválida!");
            }
        } while (opcaoSelecionada < 1 || opcaoSelecionada > itens.size());
    }
}