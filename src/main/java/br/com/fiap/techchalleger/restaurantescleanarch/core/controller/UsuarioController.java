package br.com.fiap.techchalleger.restaurantescleanarch.core.controller;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.AtualizarUsuarioTipoDto;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.CriarUsuarioDto;
import br.com.fiap.techchalleger.restaurantescleanarch.core.mapper.UsuarioMapper;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.AtualizarUsuarioUseCase;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.BuscarUsuarioUseCase;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.CriarUsuarioUseCase;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.DeletarUsuarioUseCase;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.ListarUsuariosUseCase;

import java.util.List;

public class UsuarioController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase,
                             ListarUsuariosUseCase listarUsuariosUseCase,
                             BuscarUsuarioUseCase buscarUsuarioUseCase,
                             AtualizarUsuarioUseCase atualizarUsuarioUseCase,
                             DeletarUsuarioUseCase deletarUsuarioUseCase,
                             UsuarioMapper usuarioMapper) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.listarUsuariosUseCase = listarUsuariosUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.atualizarUsuarioUseCase = atualizarUsuarioUseCase;
        this.deletarUsuarioUseCase = deletarUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    public String criarUsuario(CriarUsuarioDto dto) {
        Usuario usuario = usuarioMapper.map(dto);
        return criarUsuarioUseCase.criarUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return listarUsuariosUseCase.listarUsuarios();
    }

    public Usuario buscarPorId(Long id) {
        return buscarUsuarioUseCase.buscarPorId(id);
    }

    public Usuario atualizarUsuarioTipo(Long id, AtualizarUsuarioTipoDto dto) {
        return atualizarUsuarioUseCase.atualizarUsuarioTipo(id, dto);
    }

    public void deletarUsuario(Long id) {
        deletarUsuarioUseCase.deletarUsuario(id);
    }
}