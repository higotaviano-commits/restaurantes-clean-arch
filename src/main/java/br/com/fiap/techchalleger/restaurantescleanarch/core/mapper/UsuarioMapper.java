package br.com.fiap.techchalleger.restaurantescleanarch.core.mapper;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.AtualizarUsuarioTipoDto;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.CriarUsuarioDto;

public class UsuarioMapper {

    public Usuario map(Long id, String nome, String email, String senha, AtualizarUsuarioTipoDto dto) {
        return new Usuario(id, nome, email, senha, dto.getUsuarioTipoId());
    }

    public Usuario map(CriarUsuarioDto dto) {
        return new Usuario(null, dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getUsuarioTipoId());
    }

}

