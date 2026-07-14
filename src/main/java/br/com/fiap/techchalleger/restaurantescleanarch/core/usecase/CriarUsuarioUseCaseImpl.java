package br.com.fiap.techchalleger.restaurantescleanarch.core.usecase;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.exception.EntidadeJaExisteException;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;

public class CriarUsuarioUseCaseImpl implements CriarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public CriarUsuarioUseCaseImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public String criarUsuario(Usuario usuario) {

        validarEmailJaCadastrado(usuario);

        return usuarioGateway.criarUsuario(usuario);
    }

    private void validarEmailJaCadastrado(Usuario usuario) {
        if (usuarioGateway.usuarioJaExiste(usuario.getEmail())) {
            throw new EntidadeJaExisteException("Já existe um usuário cadastrado com este e-mail.");
        }
    }
}
