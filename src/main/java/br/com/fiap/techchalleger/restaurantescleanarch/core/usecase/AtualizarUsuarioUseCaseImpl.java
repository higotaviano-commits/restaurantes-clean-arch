package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;

public class AtualizarUsuarioUseCaseImpl implements AtualizarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public AtualizarUsuarioUseCaseImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public Usuario atualizarUsuarioTipo(Long id, Usuario usuario) {
        validarUsuarioExiste(id);
        return usuarioGateway.atualizarUsuarioTipo(id, usuario);
    }

    private void validarUsuarioExiste(Long id) {
        Usuario usuario = usuarioGateway.buscarPorId(id);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + id);
        }
    }

}

