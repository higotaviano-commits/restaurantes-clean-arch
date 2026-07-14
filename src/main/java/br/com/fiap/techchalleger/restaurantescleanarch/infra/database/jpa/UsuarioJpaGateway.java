package br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa;

import br.com.fiap.techchalleger.restaurantescleanarch.core.domain.Usuario;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioGateway;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.entity.UsuarioEntity;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.repository.UsuarioRepository;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.mapper.UsuarioEntityMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioJpaGateway implements UsuarioGateway {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;

    public UsuarioJpaGateway(UsuarioRepository usuarioRepository,
                             UsuarioEntityMapper usuarioEntityMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioEntityMapper = usuarioEntityMapper;
    }

    @Override
    public String criarUsuario(Usuario usuario) {
        try {
            UsuarioEntity entity = usuarioEntityMapper.toEntity(usuario);
            UsuarioEntity saved = usuarioRepository.save(entity);
            return "Usuário criado com sucesso. ID: " + saved.getId();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar usuário", e);
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        try {
            return usuarioRepository.findAll()
                    .stream()
                    .map(usuarioEntityMapper::toDomain)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar usuários", e);
        }
    }

    @Override
    public void deletarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar usuário", e);
        }
    }

    @Override
    public boolean usuarioJaExiste(String email) {
        try {
            return usuarioRepository.existsByEmailIgnoreCase(email);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar existência do usuário", e);
        }
    }

    @Override
    public Usuario atualizarUsuarioTipo(Long id, Usuario usuario) {
        try {
            Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
            if (optional.isEmpty()) {
                throw new RuntimeException("Usuário não encontrado: " + id);
            }

            UsuarioEntity entity = optional.get();
            entity.setUsuarioTipoId(usuario.getUsuarioTipoId());

            UsuarioEntity saved = usuarioRepository.save(entity);

            return usuarioEntityMapper.toDomain(saved);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar tipo de usuário", e);
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {
        try {
            Optional<UsuarioEntity> optional = usuarioRepository.findById(id);
            if (optional.isEmpty()) {
                return null;
            }
            return usuarioEntityMapper.toDomain(optional.get());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuário por ID", e);
        }
    }

}

