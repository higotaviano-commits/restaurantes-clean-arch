package br.com.fiap.techchalleger.restaurantescleanarch.core.controller;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.AtualizarUsuarioTipoDto;
import br.com.fiap.techchalleger.restaurantescleanarch.core.mapper.UsuarioMapper;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.AtualizarUsuarioUseCase;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;

public class UsuarioController {

    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioGateway usuarioGateway;

    public UsuarioController(AtualizarUsuarioUseCase atualizarUsuarioUseCase,
                             UsuarioMapper usuarioMapper,
                             UsuarioGateway usuarioGateway) {
        this.atualizarUsuarioUseCase = atualizarUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario atualizarUsuarioTipo(Long id, AtualizarUsuarioTipoDto dto) {
        Usuario usuarioExistente = usuarioGateway.buscarPorId(id);

        Usuario usuario = usuarioMapper.map(
                usuarioExistente.getId(),
                usuarioExistente.getNome(),
                usuarioExistente.getEmail(),
                usuarioExistente.getSenha(),
                dto
        );

        return atualizarUsuarioUseCase.atualizarUsuarioTipo(id, usuario);
    }

}

