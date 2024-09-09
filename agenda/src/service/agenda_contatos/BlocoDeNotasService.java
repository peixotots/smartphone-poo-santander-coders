package service.agenda_contatos;

import exception.NotaNaoEncontradaException;
import exception.SenhaInvalidaException;
import model.Notas;

import java.util.ArrayList;
import java.util.List;

public class BlocoDeNotasService {
    private List<Notas> notas = new ArrayList<Notas>();
    private List<Notas> notasPrivadas = new ArrayList<Notas>();

    public void criarNota(Notas nota) {
        try {
            notas.add(nota);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar a nota: " + e.getMessage());
        }
    }

    public void criarNotaPrivada(Notas notaPrivada) {
        try {
            notasPrivadas.add(notaPrivada);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar a nota privada: " + e.getMessage());
        }
    }

    public boolean verificarSenha(String senha) throws SenhaInvalidaException {
        if (notasPrivadas == null || notasPrivadas.isEmpty()) {
            throw new SenhaInvalidaException("Nenhuma nota privada encontrada.");
        }

        for (Notas nota : notasPrivadas) {
            if (senha.equals(nota.getSenha())) {
                return true;
            }
        }
        throw new SenhaInvalidaException("Senha inválida!");
    }

    public boolean excluirNota(String titulo) throws NotaNaoEncontradaException {
        boolean notaEncontrada = false;

        if (notas != null && !notas.isEmpty()) {
            for (int i = 0; i < notas.size(); i++) {
                if (titulo.equals(notas.get(i).getTitulo())) {
                    notas.remove(i);
                    notaEncontrada = true;
                    break;
                }
            }
        }
        if (!notaEncontrada) {
            throw new NotaNaoEncontradaException("Nota com título '" + titulo + "' não encontrada.");
        }
        return notaEncontrada;
    }

    public boolean excluirNotaPrivada(String titulo) throws NotaNaoEncontradaException {
        boolean notaEncontrada = false;

        if (notasPrivadas != null && !notasPrivadas.isEmpty()) {
            for (int i = 0; i < notasPrivadas.size(); i++) {
                if (titulo.equals(notasPrivadas.get(i).getTitulo())) {
                    notasPrivadas.remove(i);
                    notaEncontrada = true;
                    break;
                }
            }
        }

        if (!notaEncontrada) {
            throw new NotaNaoEncontradaException("Nota com título '" + titulo + "' não encontrada.");
        }
        return notaEncontrada;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    public List<Notas> getNotasPrivadas() {
        return notasPrivadas;
    }
}