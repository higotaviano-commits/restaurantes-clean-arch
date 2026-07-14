package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.exception.EntidadeJaExisteException;
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
@DisplayName("CriarUsuarioUseCaseImpl")
class CriarUsuarioUseCaseImplTest {

    private CriarUsuarioUseCaseImpl useCase;

    @Mock
    private UsuarioGateway usuarioGateway;

    @BeforeEach
    void setUp() {
        useCase = new CriarUsuarioUseCaseImpl(usuarioGateway);
    }

    @Test
    @DisplayName("Deve criar usuário com sucesso")
    void testCriarUsuarioComSucesso() {

        Usuario usuario = new Usuario(null, "João Silva", "joao@email.com", "senha123", 1L);

        when(usuarioGateway.usuarioJaExiste("joao@email.com")).thenReturn(false);
        when(usuarioGateway.criarUsuario(usuario)).thenReturn("Usuário criado com sucesso. ID: 1");

        String resultado = useCase.criarUsuario(usuario);

        assertNotNull(resultado);
        assertEquals("Usuário criado com sucesso. ID: 1", resultado);
        verify(usuarioGateway, times(1)).usuarioJaExiste("joao@email.com");
        verify(usuarioGateway, times(1)).criarUsuario(usuario);
    }

    @Test
    @DisplayName("Deve lançar exceção quando e-mail já existe")
    void testCriarUsuarioEmailJaExiste() {

        Usuario usuario = new Usuario(null, "João Silva", "joao@email.com", "senha123", 1L);

        when(usuarioGateway.usuarioJaExiste("joao@email.com")).thenReturn(true);

        EntidadeJaExisteException exception = assertThrows(
                EntidadeJaExisteException.class,
                () -> useCase.criarUsuario(usuario)
        );

        assertEquals("Já existe um usuário cadastrado com este e-mail.", exception.getMessage());
        verify(usuarioGateway, times(1)).usuarioJaExiste("joao@email.com");
        verify(usuarioGateway, never()).criarUsuario(any(Usuario.class));
    }
}
