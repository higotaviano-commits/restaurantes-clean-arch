package br.com.fiap.techchalleger.restaurantescleanarch.infra.web;

import br.com.fiap.techchalleger.restaurantescleanarch.core.controller.UsuarioController;
import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.AtualizarUsuarioTipoDto;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.CriarUsuarioDto;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.web.json.UsuarioJson;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioApiController {

    private final UsuarioController usuarioController;

    public UsuarioApiController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    @PostMapping
    public String criar(@RequestBody UsuarioJson usuarioJson) {
        return usuarioController.criarUsuario(mapToCriarDto(usuarioJson));
    }

    @GetMapping
    public List<UsuarioJson> listar() {
        List<Usuario> lista = usuarioController.listarUsuarios();
        return lista.stream()
                .map(this::mapToJson)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioJson buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioController.buscarPorId(id);
        return mapToJson(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioJson atualizarUsuarioTipo(@PathVariable Long id, @RequestBody UsuarioJson usuarioJson) {
        AtualizarUsuarioTipoDto dto = mapToAtualizarDto(usuarioJson);
        Usuario updated = usuarioController.atualizarUsuarioTipo(id, dto);
        return new UsuarioJson(updated.getId(), updated.getUsuarioTipoId());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioController.deletarUsuario(id);
    }

    private CriarUsuarioDto mapToCriarDto(UsuarioJson json) {
        return new CriarUsuarioDto(
            json.getNome(),
            json.getEmail(),
            json.getSenha(),
            json.getUsuarioTipoId()
        );
    }

    private AtualizarUsuarioTipoDto mapToAtualizarDto(UsuarioJson usuarioJson) {
        return new AtualizarUsuarioTipoDto(usuarioJson.getUsuarioTipoId());
    }

    private UsuarioJson mapToJson(Usuario usuario) {
        return new UsuarioJson(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getUsuarioTipoId()
        );
    }
}
