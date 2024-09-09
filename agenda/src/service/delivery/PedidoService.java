//Classe responsável por exibir detalhes dos itens e confirmar pedidos

package service.delivery;

import util.Util;

import java.util.Scanner;

public class PedidoService {

    public static void exibirItem(String item, double preco) {
        System.out.println("Você escolheu: " + item);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Deseja confirmar o pedido? (1- Sim / 2- Não)");

        int confirmacao;
        Scanner scanner = new Scanner(System.in);
        do {
            confirmacao = scanner.nextInt();
            if (confirmacao == 1) {
                System.out.println("Pedido confirmado! O restaurante já está preparando o seu pedido...");
                System.out.println("Aguarde a entrega. Obrigado pela preferência! (:");
            } else if (confirmacao == 2) {
                System.out.println("Pedido cancelado.");
            } else {
                Util.erro("Opção inválida! Por favor, digite 1 para confirmar ou 2 para cancelar.");
            }
        } while (confirmacao != 1 && confirmacao != 2);
    }
}