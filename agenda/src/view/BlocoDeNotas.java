package view;

import exception.SenhaInvalidaException;
import model.Notas;
import service.bloco_notas.BlocoDeNotasService;
import util.Util;

import java.util.Scanner;

public class BlocoDeNotas {
    private final Scanner scanner = new Scanner(System.in);
    private final BlocoDeNotasService blocoDeNotasService = new BlocoDeNotasService();

    public void criarNota() {
        try {
            String titulo = Util.validarTitulo(scanner, "Digite o título: ", blocoDeNotasService);
            String descricao = Util.validarDescricao(scanner, "Digite a descrição: ");

            Notas novaNota = new Notas(titulo, descricao);
            blocoDeNotasService.criarNota(novaNota);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void criarNotaPrivada() {
        String senha = Util.validarSenha(scanner, "Crie uma senha: ");
        boolean continuar = true;

        while (continuar) {
            try {
                String titulo = Util.validarTitulo(scanner, "Digite o título: ", blocoDeNotasService);
                String descricao = Util.validarDescricao(scanner, "Digite a descrição: ");

                Notas novaNotaPrivada = new Notas(titulo, descricao, senha);
                blocoDeNotasService.criarNotaPrivada(novaNotaPrivada);

                String resposta = Util.ler(scanner, "Deseja criar outra nota privada? (s/n): ").toLowerCase();
                if (!resposta.equals("s")) {
                    continuar = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void excluirNota() {
        try {
            String tituloDaNota = Util.ler(scanner, "Digite o título da nota que deseja excluir: ");
            boolean resultado = blocoDeNotasService.excluirNota(tituloDaNota);

            if (resultado) {
                Util.escrever("Nota excluída com sucesso!");
            } else {
                Util.escrever("Não existe nota com esse título.");
            }
        } catch (Exception e) {
            Util.erro("Erro ao excluir nota: " + e.getMessage());
        }
    }

    public void excluirNotaPrivada() {
        try {
            String tituloDaNota = Util.ler(scanner, "Digite o título da nota privada que deseja excluir: ");
            if (solicitarSenha()) {
                boolean resultado = blocoDeNotasService.excluirNotaPrivada(tituloDaNota);
                if (resultado) {
                    Util.escrever("Nota excluída com sucesso!");
                }
            }
        } catch (Exception e) {
            Util.erro("Erro ao excluir nota: " + e.getMessage());
        }
    }

    private boolean solicitarSenha() {
        final int MAX_TENTATIVAS = 3;
        int tentativas = 0;

        while (tentativas < MAX_TENTATIVAS) {
            try {
                String senha = Util.ler(scanner, "Digite a senha: ");
                if (blocoDeNotasService.verificarSenha(senha)) {
                    return true;
                } else {
                    tentativas++;
                    System.out.println("Senha inválida! Você ainda tem " + (MAX_TENTATIVAS - tentativas) + " tentativa(s).");
                }
            } catch (SenhaInvalidaException e) {
                tentativas++;
                System.out.println(e.getMessage() + " Você ainda tem " + (MAX_TENTATIVAS - tentativas) + " tentativa(s).");
            }
        }

        System.out.println("Você excedeu o número máximo de tentativas. Tente novamente mais tarde.");
        return false;
    }

    public void mostrarNotasPrivadas() {
        if (blocoDeNotasService.getNotasPrivadas() == null || blocoDeNotasService.getNotasPrivadas().isEmpty()) {
            System.out.println("Nenhuma nota privada encontrada.");
            return;
        }
        if (solicitarSenha()) {
            String titulo = "NOTAS PRIVADAS";

            int maiorComprimento = Math.max(titulo.length(), blocoDeNotasService.getNotasPrivadas().stream()
                    .mapToInt(n -> n.getDescricao().length())
                    .max().orElse(0)) + 25;
            int largura = maiorComprimento;

            String bordaTopo = "╔" + "═".repeat(largura) + "╗";
            String linhaCentral = "╠" + "═".repeat(largura) + "╣";
            String bordaFim = "╚" + "═".repeat(largura) + "╝";
            String linhaTitulo = "║" + " ".repeat((largura - titulo.length()) / 2) + titulo + " ".repeat((largura - titulo.length()) / 2 + 1) + "║";

            StringBuilder listaDeNotas = new StringBuilder();
            listaDeNotas.append(bordaTopo).append("\n");
            listaDeNotas.append(linhaTitulo).append("\n");
            listaDeNotas.append(linhaCentral).append("\n");

            for (int i = 0; i < blocoDeNotasService.getNotasPrivadas().size(); i++) {
                Notas nota = blocoDeNotasService.getNotasPrivadas().get(i);

                String linhaTituloNota = "║  " + (i + 1) + ". " + nota.getTitulo() + " ".repeat(Math.max(0, largura - (nota.getTitulo().length() + 5))) + "║";
                listaDeNotas.append(linhaTituloNota).append("\n");

                String descricaoFormatada = nota.getDescricao().length() > (largura - 10)
                        ? nota.getDescricao().substring(0, largura - 10) + "..."
                        : nota.getDescricao();
                String linhaDescricaoNota = "║  - " + descricaoFormatada + " ".repeat(Math.max(0, largura - (descricaoFormatada.length() + 8))) + "    ║";
                listaDeNotas.append(linhaDescricaoNota).append("\n");
            }
            listaDeNotas.append(bordaFim);
            System.out.println(listaDeNotas.toString());
        }
    }

    public void mostrarNotas() {
        if (blocoDeNotasService.getNotas() != null && !blocoDeNotasService.getNotas().isEmpty()) {
            String titulo = "NOTAS";

            int maiorComprimento = Math.max(titulo.length(), blocoDeNotasService.getNotas().stream()
                    .mapToInt(n -> n.getDescricao().length())
                    .max().orElse(0)) + 25;
            int largura = maiorComprimento;

            String bordaTopo = "╔" + "═".repeat(largura) + "╗";
            String linhaCentral = "╠" + "═".repeat(largura) + "╣";
            String bordaFim = "╚" + "═".repeat(largura) + "╝";
            String linhaTitulo = "║" + " ".repeat((largura - titulo.length()) / 2) + titulo + " ".repeat((largura - titulo.length()) / 2 + 1) + "║";

            StringBuilder listaDeNotas = new StringBuilder();
            listaDeNotas.append(bordaTopo).append("\n");
            listaDeNotas.append(linhaTitulo).append("\n");
            listaDeNotas.append(linhaCentral).append("\n");

            for (int i = 0; i < blocoDeNotasService.getNotas().size(); i++) {
                Notas nota = blocoDeNotasService.getNotas().get(i);

                String linhaTituloNota = "║  " + (i + 1) + ". " + nota.getTitulo() + " ".repeat(Math.max(0, largura - (nota.getTitulo().length() + 5))) + "║";
                listaDeNotas.append(linhaTituloNota).append("\n");

                String descricaoFormatada = nota.getDescricao().length() > (largura - 10)
                        ? nota.getDescricao().substring(0, largura - 10) + "..."
                        : nota.getDescricao();
                String linhaDescricaoNota = "║  - " + descricaoFormatada + " ".repeat(Math.max(0, largura - (descricaoFormatada.length() + 8))) + "    ║";
                listaDeNotas.append(linhaDescricaoNota).append("\n");
            }
            listaDeNotas.append(bordaFim);
            System.out.println(listaDeNotas.toString());
        } else {
            System.out.println("Nenhuma nota encontrada.");
        }
    }
}