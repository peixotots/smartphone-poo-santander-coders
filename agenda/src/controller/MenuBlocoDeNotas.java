package controller;

import util.Util;
import view.BlocoDeNotas;

import java.util.List;

public class MenuBlocoDeNotas extends Menu {
    private final BlocoDeNotas blocoDeNotas = new BlocoDeNotas();

    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("Bloco de Notas", List.of("Adicionar Nota", "Ver Notas", "Adicionar Nota Privada", "Ver Notas Privadas", "Excluir Nota", "Excluir Nota Privada", "Sair"));
        int opcaoSelecionada;

        do {
            System.out.println(menu);
            opcaoSelecionada = Integer.parseInt(Util.validarNumero(entrada, "Digite a opção desejada: "));

            switch (opcaoSelecionada) {
                case 1:
                    try {
                        this.blocoDeNotas.criarNota();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        this.blocoDeNotas.mostrarNotas();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        this.blocoDeNotas.criarNotaPrivada();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        this.blocoDeNotas.mostrarNotasPrivadas();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        this.blocoDeNotas.excluirNota();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        this.blocoDeNotas.excluirNotaPrivada();
                    } catch (Exception e) {
                        Util.erro(e.getMessage());
                    }
                    break;
                case 7:
                    Util.erro("Saindo do bloco de notas...");
                    break;

                default:
                    Util.erro("Opção inválida!");
                    break;
            }

        } while (opcaoSelecionada != 7);
    }
}
