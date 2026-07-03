
package br.com.fiap.techchalleger.restaurantescleanarch.core.mapper;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.UsuarioTipo;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.CriarUsuarioTipoDto;

public class UsuarioTipoMapper {

    public UsuarioTipo map (CriarUsuarioTipoDto dto) {

        return new UsuarioTipo(dto.getTipo());

    }

}
