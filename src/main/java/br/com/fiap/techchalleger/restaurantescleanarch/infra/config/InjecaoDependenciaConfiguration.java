
package br.com.fiap.techchalleger.restaurantescleanarch.infra.config;

import br.com.fiap.techchalleger.restaurantescleanarch.core.controller.UsuarioTipoController;
import br.com.fiap.techchalleger.restaurantescleanarch.core.gateway.UsuarioTipoGateway;
import br.com.fiap.techchalleger.restaurantescleanarch.core.mapper.UsuarioTipoMapper;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.CriarUsuarioTipoUseCase;
import br.com.fiap.techchalleger.restaurantescleanarch.core.usecase.CriarUsuarioTipoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjecaoDependenciaConfiguration {

    @Bean
    CriarUsuarioTipoUseCase criarUsuarioTipoUseCase(
            UsuarioTipoGateway usuarioTipoGateway) {

        return new CriarUsuarioTipoUseCaseImpl(usuarioTipoGateway);
    }

    @Bean
    UsuarioTipoController usuarioTipoController(
            CriarUsuarioTipoUseCase criarUsuarioTipoUseCase,
            UsuarioTipoMapper usuarioTipoMapper) {

        return new UsuarioTipoController(
                criarUsuarioTipoUseCase,
                usuarioTipoMapper);
    }

    @Bean
    public UsuarioTipoMapper usuarioTipoMapper() {
        return new UsuarioTipoMapper();
    }
}
