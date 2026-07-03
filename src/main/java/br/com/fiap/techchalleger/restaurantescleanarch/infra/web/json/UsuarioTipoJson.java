
package br.com.fiap.techchalleger.restaurantescleanarch.infra.web.json;

public class UsuarioTipoJson {

    private Long id;
    private String tipo;

    public UsuarioTipoJson(Long id, String tipo) {
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
