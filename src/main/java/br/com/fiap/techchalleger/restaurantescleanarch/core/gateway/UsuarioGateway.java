package br.com.fiap.techchalleger.restaurantescleanarch.core.gateway;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import java.util.List;

public interface UsuarioGateway {

    String criarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario atualizarUsuarioTipo(Long id, Usuario usuario);

    Usuario buscarPorId(Long id);

    void deletarUsuario(Long id);

    boolean usuarioJaExiste(String email);

}

