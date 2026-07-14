package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;
import java.util.List;

public class ListarUsuariosUseCaseImpl implements ListarUsuariosUseCase {

    private final UsuarioGateway usuarioGateway;

    public ListarUsuariosUseCaseImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioGateway.listarUsuarios();
    }
}
