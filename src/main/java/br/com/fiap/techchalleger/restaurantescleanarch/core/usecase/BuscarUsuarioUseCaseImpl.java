package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.exception.EntidadeNaoEncontradaException;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;

public class BuscarUsuarioUseCaseImpl implements BuscarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public BuscarUsuarioUseCaseImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioGateway.buscarPorId(id);
        if (usuario == null) {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado com o ID: " + id);
        }
        return usuario;
    }

}
