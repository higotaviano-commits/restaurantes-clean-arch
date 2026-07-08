package br.com.fiap.techchalleger.restaurantescleanarch.core.dto;

public class AtualizarUsuarioTipoDto {

    private Long usuarioTipoId;

    public AtualizarUsuarioTipoDto(Long usuarioTipoId) {
        this.usuarioTipoId = usuarioTipoId;
    }

    public Long getUsuarioTipoId() {
        return usuarioTipoId;
    }
}

