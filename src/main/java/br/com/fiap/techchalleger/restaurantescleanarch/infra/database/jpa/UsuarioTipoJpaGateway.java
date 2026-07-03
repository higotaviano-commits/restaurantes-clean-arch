package br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.UsuarioTipo;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioTipoGateway;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.entity.UsuarioTipoEntity;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.repository.UsuarioTipoRepository;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.mapper.UsuarioTipoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioTipoJpaGateway implements UsuarioTipoGateway {

    private final UsuarioTipoRepository usuarioTipoRepository;
    private final UsuarioTipoEntityMapper usuarioTipoEntityMapper;

    public UsuarioTipoJpaGateway(UsuarioTipoRepository usuarioTipoRepository,
                                 UsuarioTipoEntityMapper usuarioTipoEntityMapper) {
        this.usuarioTipoRepository = usuarioTipoRepository;
        this.usuarioTipoEntityMapper = usuarioTipoEntityMapper;
    }


    @Override
    public String criarUsuarioTipo(UsuarioTipo tipo) {
        try {

            UsuarioTipoEntity usuarioTipoEntity= usuarioTipoEntityMapper.toEntity(tipo);

            return usuarioTipoRepository.save(usuarioTipoEntity).getTipo();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar tipo de usuário", e);
        }
    }
}
