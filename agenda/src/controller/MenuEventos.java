package controller;
import model.Evento;
import service.agenda_contatos.AgendaEventosService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;

public class MenuEventos extends Menu {

    private AgendaEventosService agenda;
    private DateTimeFormatter formatter;

    public MenuEventos() {
        super(); // Inicializa o Scanner da classe base Menu
        agenda = new AgendaEventosService();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void selecionaOpcao() {
    }

     public void exibirMenu() {
        int opcao = 0;
        List<String> opcoes = Arrays.asList(
                "Adicionar evento",
                "Remover evento",
                "Listar eventos",
                "Sair"
        );

        do {
            String menu = geraMenuComOpcoes("Menu de Eventos", opcoes);
            System.out.println(menu);

            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.print("Escolha uma opção: ");
                try {
                    opcao = entrada.nextInt();
                    entrada.nextLine();  // Limpa o buffer

                    if (opcao < 1 || opcao > 4) {
                        System.out.println("Opção inválida. Por favor, escolha um número entre 1 e 4.");
                    } else {
                        entradaValida = true; // Entrada é válida
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    entrada.nextLine(); // Limpa o buffer de entrada
                }
            }

            switch (opcao) {
                case 1:
                    adicionarEvento();
                    break;
                case 2:
                    removerEvento();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opcao != 4);
    }

    private void adicionarEvento() {
        System.out.print("Digite o nome do evento: ");
        String nome = entrada.nextLine();
        LocalDate data = null;
        boolean dataValida = false;
        while (!dataValida) {
            System.out.print("Digite a data do evento (dd/MM/yyyy): ");
            String dataStr = entrada.nextLine();
            try {
                data = LocalDate.parse(dataStr, formatter);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, tente novamente.");
            }
        }
        agenda.adicionarEvento(new Evento(nome, data));
        System.out.println("Evento adicionado.");
    }

    private void removerEvento() {
        System.out.print("Digite o nome do evento a ser removido: ");
        String nome = entrada.nextLine();
        agenda.removerEvento(nome);
        System.out.println("Evento removido, se existia.");
    }

    private void listarEventos() {
        agenda.listarEventos();
    }

    public static void main(String[] args) {
        MenuEventos menuEventos = new MenuEventos();
        menuEventos.exibirMenu();
    }
}
