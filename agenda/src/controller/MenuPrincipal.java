package controller;

import service.delivery.MenuDeliveryService;
import util.Util;

import java.util.List;

public class MenuPrincipal extends Menu {

    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("SMARTPHONE", List.of("Agenda de contatos", "Bloco de notas", "Calendário", "Previsão do tempo", "Delivery", "Desligar"));

        int opcaoSelecionada = 0;
        do {
            System.out.println(menu);
            opcaoSelecionada = entrada.nextInt();
            switch (opcaoSelecionada) {
                case 1:
                    MenuContatos menuContatos = new MenuContatos();
                    menuContatos.selecionaOpcao();
                    break;

                case 2:
                    MenuBlocoDeNotas menuBlocoDeNotas = new MenuBlocoDeNotas();
                    menuBlocoDeNotas.selecionaOpcao();
                    break;

                case 3:
                    MenuEventos menuEventos = new MenuEventos();
                    menuEventos.exibirMenu();
                    break;

                case 4:
                    // chamar o menu da previsão do tempo
                    break;

                case 5:
                    MenuDeliveryService menuDeliveryService = new MenuDeliveryService();
                    menuDeliveryService.selecionaOpcao();
                    break;

                case 6:
                    Util.erro("Desligando o aparelho...");
                    break;

                default:
                    Util.erro("Opção inválida!");
                    break;

            }
        } while (opcaoSelecionada != 6);

    }


}
