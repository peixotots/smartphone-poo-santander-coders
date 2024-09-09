package model;
import java.time.LocalDate;

public class Evento {
    private String nome;
    private LocalDate data;

    public Evento(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return nome + " (Data: " + data + ")";
    }
}
