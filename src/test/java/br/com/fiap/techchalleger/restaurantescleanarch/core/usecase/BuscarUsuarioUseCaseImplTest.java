package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.exception.EntidadeNaoEncontradaException;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("BuscarUsuarioUseCaseImpl")
class BuscarUsuarioUseCaseImplTest {

    private BuscarUsuarioUseCaseImpl useCase;

    @Mock
    private UsuarioGateway usuarioGateway;

    @BeforeEach
    void setUp() {
        useCase = new BuscarUsuarioUseCaseImpl(usuarioGateway);
    }

    @Test
    @DisplayName("Deve buscar usuário por id com sucesso")
    void testBuscarUsuarioComSucesso() {

        Usuario usuario = new Usuario(1L, "João", "joao@email.com", "senha123", 1L);

        when(usuarioGateway.buscarPorId(1L)).thenReturn(usuario);

        Usuario resultado = useCase.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(usuarioGateway, times(1)).buscarPorId(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção quando usuário não existe")
    void testBuscarUsuarioNaoExistente() {

        when(usuarioGateway.buscarPorId(99L)).thenReturn(null);

        EntidadeNaoEncontradaException exception = assertThrows(
                EntidadeNaoEncontradaException.class,
                () -> useCase.buscarPorId(99L)
        );

        assertEquals("Usuário não encontrado com o ID: 99", exception.getMessage());
        verify(usuarioGateway, times(1)).buscarPorId(99L);
    }
}
