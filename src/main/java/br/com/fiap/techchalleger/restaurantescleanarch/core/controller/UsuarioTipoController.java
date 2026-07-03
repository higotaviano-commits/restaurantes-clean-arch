
package br.com.fiap.techchalleger.restaurantescleanarch.core.controller;

import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.CriarUsuarioTipoDto;
import br.com.fiap.techchalleger.restaurantescleanarch.core.mapper.UsuarioTipoMapper;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.CriarUsuarioTipoUseCase;

public class UsuarioTipoController {

    private final CriarUsuarioTipoUseCase criarUsuarioTipoUseCase;
    private final UsuarioTipoMapper usuarioTipoMapper;

    public UsuarioTipoController(CriarUsuarioTipoUseCase criarUsuarioTipoUseCase,
                                 UsuarioTipoMapper usuarioTipoMapper) {
        this.criarUsuarioTipoUseCase = criarUsuarioTipoUseCase;
        this.usuarioTipoMapper = usuarioTipoMapper;
    }

    public String criarUsuarioTipo(CriarUsuarioTipoDto dto) {
        var usuarioTipo = usuarioTipoMapper.map(dto);

        return criarUsuarioTipoUseCase.criarUsuarioTipo(usuarioTipo);
    }

}
