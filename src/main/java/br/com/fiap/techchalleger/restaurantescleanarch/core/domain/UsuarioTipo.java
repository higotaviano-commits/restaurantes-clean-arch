
package br.com.fiap.techchalleger.restaurantescleanarch.core.domain;

import java.util.Set;

public class UsuarioTipo {

    private String tipo;

    public UsuarioTipo(String tipo) {

        if (!tipo.equalsIgnoreCase("CLIENTE")
                && !tipo.equalsIgnoreCase("DONO_RESTAURANTE")) {

            throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }

        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }

}
