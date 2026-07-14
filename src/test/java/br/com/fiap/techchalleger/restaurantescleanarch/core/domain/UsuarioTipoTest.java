package br.com.fiap.techchalleger.restaurantescleanarch.core.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioTipoTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "   "
    })
    void deveRejeitarNomeDoTipoEmBranco(String tipo) {
        assertThrows(IllegalArgumentException.class,
                () -> new UsuarioTipo(tipo));
    }

    @Test
    void deveRejeitarNomeDoTipoNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new UsuarioTipo(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "CLIENTE",
            "cliente",
            "DONO_RESTAURANTE",
            "dono_restaurante",
            "ADMIN",
            "GERENTE",
            "Entregador"
    })
    void devePermitirQualquerNomeDeTipoNaoVazio(String tipo) {
        UsuarioTipo usuarioTipo = new UsuarioTipo(tipo);

        assertEquals(tipo, usuarioTipo.getTipo());
    }
}
