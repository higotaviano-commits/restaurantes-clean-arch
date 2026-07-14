package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.UsuarioTipo;
import br.com.fiap.techchalleger.restaurantescleanarch.core.exception.EntidadeNaoEncontradaException;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioTipoGateway;

public class BuscarUsuarioTipoUseCaseImpl implements BuscarUsuarioTipoUseCase {

    private final UsuarioTipoGateway usuarioTipoGateway;

    public BuscarUsuarioTipoUseCaseImpl(UsuarioTipoGateway usuarioTipoGateway) {
        this.usuarioTipoGateway = usuarioTipoGateway;
    }

    @Override
    public UsuarioTipo buscarPorId(Long id) {
        UsuarioTipo usuarioTipo = usuarioTipoGateway.buscarPorId(id);
        if (usuarioTipo == null) {
            throw new EntidadeNaoEncontradaException("Tipo de usuário não encontrado com o ID: " + id);
        }
        return usuarioTipo;
    }

}
