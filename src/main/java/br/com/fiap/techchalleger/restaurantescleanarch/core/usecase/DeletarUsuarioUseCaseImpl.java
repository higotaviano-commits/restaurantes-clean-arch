package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.exception.EntidadeNaoEncontradaException;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;

public class DeletarUsuarioUseCaseImpl implements DeletarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public DeletarUsuarioUseCaseImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public void deletarUsuario(Long id) {
        validarUsuarioExiste(id);
        usuarioGateway.deletarUsuario(id);
    }

    private void validarUsuarioExiste(Long id) {
        var usuario = usuarioGateway.buscarPorId(id);
        if (usuario == null) {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado com o ID: " + id);
        }
    }

}
