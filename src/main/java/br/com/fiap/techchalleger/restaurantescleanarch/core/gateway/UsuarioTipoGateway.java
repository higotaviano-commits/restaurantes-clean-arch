package br.com.fiap.techchalleger.restaurantescleanarch.core.gateway;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.UsuarioTipo;
import java.util.List;

public interface UsuarioTipoGateway {

    String criarUsuarioTipo(UsuarioTipo tipo);

    List<UsuarioTipo> listarUsuarioTipo();

    UsuarioTipo buscarPorId(Long id);

    UsuarioTipo atualizarUsuarioTipo(Long id, UsuarioTipo tipo);

    void deletarUsuarioTipo(Long id);

    boolean usuarioTipoJaExiste(UsuarioTipo tipo);

}
