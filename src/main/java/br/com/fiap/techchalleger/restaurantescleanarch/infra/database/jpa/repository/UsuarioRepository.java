package br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.repository;

import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}

