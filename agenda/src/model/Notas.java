package model;

public class Notas {
    public String titulo;
    private String descricao;

    public Notas(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return STR."""

                ############################
                ##### DADOS DO CONTATO #####
                ############################

                Título: \{titulo}
                descrição: \{descricao}
                """;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
