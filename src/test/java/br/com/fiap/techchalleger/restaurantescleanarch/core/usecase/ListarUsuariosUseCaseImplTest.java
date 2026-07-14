package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ListarUsuariosUseCaseImpl")
class ListarUsuariosUseCaseImplTest {

    private ListarUsuariosUseCaseImpl useCase;

    @Mock
    private UsuarioGateway usuarioGateway;

    @BeforeEach
    void setUp() {
        useCase = new ListarUsuariosUseCaseImpl(usuarioGateway);
    }

    @Test
    @DisplayName("Deve listar usuários")
    void testListarUsuarios() {

        List<Usuario> usuarios = List.of(
                new Usuario(1L, "João", "joao@email.com", "senha123", 1L),
                new Usuario(2L, "Maria", "maria@email.com", "senha456", 2L)
        );

        when(usuarioGateway.listarUsuarios()).thenReturn(usuarios);

        List<Usuario> resultado = useCase.listarUsuarios();

        assertEquals(2, resultado.size());
        verify(usuarioGateway, times(1)).listarUsuarios();
    }
}
