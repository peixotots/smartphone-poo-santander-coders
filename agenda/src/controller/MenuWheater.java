package controller;

import view.WeatherForecast;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class MenuWheater extends Menu {
    private List<WeatherForecast> cities;

    public MenuWheater() {
        cities = new ArrayList<>();
        // Cidade padrão São Paulo-SP
        cities.add(new WeatherForecast("São Paulo - SP"));
    }

    @Override
    public void selecionaOpcao() {
        List<String> opcoes = List.of("Ver Previsão", "Adicionar Cidade", "Editar Cidade", "Excluir Cidade", "Sair");
        boolean continuar = true;

        while (continuar) {
            System.out.println(Menu.geraMenuComOpcoes("MENU PREVISÃO DO TEMPO", opcoes));
            int opcao = Integer.parseInt(Util.validarNumero(entrada, "Escolha uma opção: "));

            switch (opcao) {
                case 1:
                    verPrevisao();
                    break;
                case 2:
                    adicionarCidade();
                    break;
                case 3:
                    editarCidade();
                    break;
                case 4:
                    excluirCidade();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void verPrevisao() {
        System.out.println("\nLista de Cidades e Previsões:\n");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i));
        }
        System.out.println();
    }

    private void adicionarCidade() {
        String cidadeNome = Util.ler(entrada, "Digite o nome da cidade: ");
        cities.add(new WeatherForecast(cidadeNome));
        System.out.println("Cidade adicionada com sucesso.");
    }

    private void editarCidade() {
        if (cities.isEmpty()) {
            System.out.println("Não há cidades cadastradas para editar.");
            return;
        }

        verPrevisao();

        int index = Integer.parseInt(Util.validarNumero(entrada, "Digite o número da cidade que deseja editar: "));
        if (index > 0 && index <= cities.size()) {
            String novaCidade = Util.ler(entrada, "Digite o novo nome da cidade: ");
            cities.get(index - 1).setCity(novaCidade);
            System.out.println("Cidade editada com sucesso.");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private void excluirCidade() {
        if (cities.isEmpty()) {
            System.out.println("Não há cidades cadastradas para excluir.");
            return;
        }

        verPrevisao();  // Mostra a lista de cidades

        int index = Integer.parseInt(Util.validarNumero(entrada, "Digite o número da cidade que deseja excluir: "));
        if (index > 0 && index <= cities.size()) {
            cities.remove(index - 1);
            System.out.println("Cidade excluída com sucesso.");
        } else {
            System.out.println("Número inválido.");
        }
    }
}
