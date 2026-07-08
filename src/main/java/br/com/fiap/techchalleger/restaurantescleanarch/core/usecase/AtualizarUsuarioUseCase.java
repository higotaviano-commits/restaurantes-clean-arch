package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;

public interface AtualizarUsuarioUseCase {

    Usuario atualizarUsuarioTipo(Long id, Usuario usuario);

}

