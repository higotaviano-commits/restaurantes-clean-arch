package br.com.fiap.techchalleger.restaurantescleanarch.core.dto;

public class CriarUsuarioTipoDto {

    private String tipo;

    public CriarUsuarioTipoDto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
