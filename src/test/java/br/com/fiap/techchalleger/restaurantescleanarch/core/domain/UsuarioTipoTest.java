package br.com.fiap.techchalleger.restaurantescleanarch.core.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioTipoTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "ADMIN",
            "GERENTE",
            "DONO",
            "123"
    })
    void deveRejeitarTiposInvalidos(String tipo) {
        assertThrows(IllegalArgumentException.class,
                () -> new UsuarioTipo(tipo));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "CLIENTE",
            "cliente",
            "DONO_RESTAURANTE",
            "dono_restaurante"
    })
    void devePermitirTiposValidos(String tipo) {
        UsuarioTipo usuarioTipo = new UsuarioTipo(tipo);

        assertEquals(tipo, usuarioTipo.getTipo());
    }
}
