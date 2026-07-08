package br.com.fiap.techchalleger.restaurantescleanarch.infra.web;

import br.com.fiap.techchalleger.restaurantescleanarch.core.controller.UsuarioController;
import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.AtualizarUsuarioTipoDto;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.web.json.UsuarioJson;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/usuarios")
public class UsuarioApiController {

    private final UsuarioController usuarioController;

    public UsuarioApiController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    @PutMapping("/{id}")
    public UsuarioJson atualizarUsuarioTipo(@PathVariable Long id, @RequestBody UsuarioJson usuarioJson) {
        AtualizarUsuarioTipoDto dto = mapToDto(usuarioJson);
        Usuario updated = usuarioController.atualizarUsuarioTipo(id, dto);
        return new UsuarioJson(updated.getId(), updated.getUsuarioTipoId());
    }

    private AtualizarUsuarioTipoDto mapToDto(UsuarioJson usuarioJson) {
        return new AtualizarUsuarioTipoDto(usuarioJson.getUsuarioTipoId());
    }
}

