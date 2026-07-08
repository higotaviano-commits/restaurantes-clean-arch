package br.com.fiap.techchalleger.restaurantescleanarch.infra.database.mapper;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getUsuarioTipoId()
        );
    }

    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getSenha(),
                entity.getUsuarioTipoId()
        );
    }
}

