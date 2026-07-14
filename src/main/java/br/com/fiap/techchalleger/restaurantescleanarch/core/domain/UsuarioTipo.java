
package br.com.fiap.techchalleger.restaurantescleanarch.core.domain;

public class UsuarioTipo {

    private Long id;
    private String tipo;

    public UsuarioTipo(String tipo) {
        this(null, tipo);
    }

    public UsuarioTipo(Long id, String tipo) {

        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Nome do tipo de usuário não pode ser nulo ou vazio.");
        }

        this.id = id;
        this.tipo = tipo;

    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

}
