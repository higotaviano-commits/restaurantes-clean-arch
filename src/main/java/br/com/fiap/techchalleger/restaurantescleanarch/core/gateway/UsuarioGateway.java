package br.com.fiap.techchalleger.restaurantescleanarch.core.gateway;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;

public interface UsuarioGateway {

    Usuario atualizarUsuarioTipo(Long id, Usuario usuario);

    Usuario buscarPorId(Long id);

}

