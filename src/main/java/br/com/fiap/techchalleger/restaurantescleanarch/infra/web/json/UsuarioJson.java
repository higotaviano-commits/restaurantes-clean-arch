package br.com.fiap.techchalleger.restaurantescleanarch.infra.web.json;

public class UsuarioJson {

    private Long id;
    private Long usuarioTipoId;

    public UsuarioJson(Long id, Long usuarioTipoId) {
        this.id = id;
        this.usuarioTipoId = usuarioTipoId;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuarioTipoId() {
        return usuarioTipoId;
    }

}

