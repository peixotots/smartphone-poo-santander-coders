package model;

public class Notas {
    public String titulo;
    private String descricao;
    private String senha;

    public Notas(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Notas(String titulo, String descricao, String senha) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }
}
