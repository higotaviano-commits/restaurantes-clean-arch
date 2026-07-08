package br.com.fiap.techchalleger.restaurantescleanarch.core.mapper;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.AtualizarUsuarioTipoDto;

public class UsuarioMapper {

    public Usuario map(Long id, String nome, String email, String senha, AtualizarUsuarioTipoDto dto) {
        return new Usuario(id, nome, email, senha, dto.getUsuarioTipoId());
    }

}

