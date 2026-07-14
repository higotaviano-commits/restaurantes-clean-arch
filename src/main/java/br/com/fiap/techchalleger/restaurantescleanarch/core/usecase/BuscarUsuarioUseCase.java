package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;

public interface BuscarUsuarioUseCase {

    Usuario buscarPorId(Long id);

}
