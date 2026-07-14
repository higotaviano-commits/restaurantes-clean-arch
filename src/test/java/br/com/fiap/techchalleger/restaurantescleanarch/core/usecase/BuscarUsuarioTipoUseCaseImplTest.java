package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.UsuarioTipo;
import br.com.fiap.techchalleger.restaurantescleanarch.core.exception.EntidadeNaoEncontradaException;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioTipoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("BuscarUsuarioTipoUseCaseImpl")
class BuscarUsuarioTipoUseCaseImplTest {

    private BuscarUsuarioTipoUseCaseImpl useCase;

    @Mock
    private UsuarioTipoGateway usuarioTipoGateway;

    @BeforeEach
    void setUp() {
        useCase = new BuscarUsuarioTipoUseCaseImpl(usuarioTipoGateway);
    }

    @Test
    @DisplayName("Deve buscar tipo de usuário por id com sucesso")
    void testBuscarUsuarioTipoComSucesso() {

        UsuarioTipo tipo = new UsuarioTipo(1L, "CLIENTE");

        when(usuarioTipoGateway.buscarPorId(1L)).thenReturn(tipo);

        UsuarioTipo resultado = useCase.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("CLIENTE", resultado.getTipo());
        verify(usuarioTipoGateway, times(1)).buscarPorId(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção quando tipo de usuário não existe")
    void testBuscarUsuarioTipoNaoExistente() {

        when(usuarioTipoGateway.buscarPorId(99L)).thenReturn(null);

        EntidadeNaoEncontradaException exception = assertThrows(
                EntidadeNaoEncontradaException.class,
                () -> useCase.buscarPorId(99L)
        );

        assertEquals("Tipo de usuário não encontrado com o ID: 99", exception.getMessage());
        verify(usuarioTipoGateway, times(1)).buscarPorId(99L);
    }
}
