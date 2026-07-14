package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.UsuarioTipo;

public interface BuscarUsuarioTipoUseCase {

    UsuarioTipo buscarPorId(Long id);

}
