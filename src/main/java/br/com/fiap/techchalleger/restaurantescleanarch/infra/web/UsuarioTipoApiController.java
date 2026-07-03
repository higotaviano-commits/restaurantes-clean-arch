
package br.com.fiap.techchalleger.restaurantescleanarch.infra.web;

import br.com.fiap.techchalleger.restaurantescleanarch.core.controller.UsuarioTipoController;
import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.UsuarioTipo;
import br.com.fiap.techchalleger.restaurantescleanarch.core.dto.CriarUsuarioTipoDto;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.web.json.UsuarioTipoJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios-tipos")
public class UsuarioTipoApiController {

    private final UsuarioTipoController usuarioTipoController;

    public UsuarioTipoApiController(UsuarioTipoController usuarioTipoController) {
        this.usuarioTipoController = usuarioTipoController;
    }

    @PostMapping
    public String criar(@RequestBody UsuarioTipoJson usuarioTipoJson) {
        return usuarioTipoController.criarUsuarioTipo(mapToDto(usuarioTipoJson));
    }

    private CriarUsuarioTipoDto mapToDto(UsuarioTipoJson usuarioTipoJson) {
        return new CriarUsuarioTipoDto(usuarioTipoJson.getTipo());
    }
}
