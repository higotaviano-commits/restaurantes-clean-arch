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
@DisplayName("DeletarUsuarioUseCaseImpl")
class DeletarUsuarioUseCaseImplTest {

    private DeletarUsuarioUseCaseImpl useCase;

    @Mock
    private UsuarioGateway usuarioGateway;

    @BeforeEach
    void setUp() {
        useCase = new DeletarUsuarioUseCaseImpl(usuarioGateway);
    }

    @Test
    @DisplayName("Deve deletar usuário com sucesso")
    void testDeletarUsuarioComSucesso() {

        Usuario usuario = new Usuario(1L, "João", "joao@email.com", "senha123", 1L);

        when(usuarioGateway.buscarPorId(1L)).thenReturn(usuario);

        useCase.deletarUsuario(1L);

        verify(usuarioGateway, times(1)).buscarPorId(1L);
        verify(usuarioGateway, times(1)).deletarUsuario(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção quando usuário não existe")
    void testDeletarUsuarioNaoExistente() {

        when(usuarioGateway.buscarPorId(99L)).thenReturn(null);

        EntidadeNaoEncontradaException exception = assertThrows(
                EntidadeNaoEncontradaException.class,
                () -> useCase.deletarUsuario(99L)
        );

        assertEquals("Usuário não encontrado com o ID: 99", exception.getMessage());
        verify(usuarioGateway, times(1)).buscarPorId(99L);
        verify(usuarioGateway, never()).deletarUsuario(anyLong());
    }
}
