package br.com.fiap.techchalleger.restaurantescleanarch.infra.web;

import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.entity.UsuarioEntity;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.repository.UsuarioRepository;
import br.com.fiap.techchalleger.restaurantescleanarch.infra.web.json.UsuarioJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("UsuarioController - Testes de Integração")
class UsuarioControllerIT {

    private static final Long TIPO_CLIENTE = 1L;
    private static final Long TIPO_DONO = 2L;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setup() {
        usuarioRepository.deleteAll();
    }

    @Test
    @DisplayName("Deve criar usuário")
    void deveCriarUsuario() {

        UsuarioJson dto = new UsuarioJson(
                null,
                "Maria",
                "maria@teste.com",
                "123456",
                TIPO_CLIENTE);

        ResponseEntity<String> response =
                restTemplate.postForEntity("/usuarios", dto, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("ID:"));

        assertEquals(1, usuarioRepository.count());
    }

    @Test
    @DisplayName("Deve retornar conflito ao criar usuário com e-mail já cadastrado")
    void deveRetornarConflitoAoCriarUsuarioComEmailDuplicado() {

        criarUsuario();

        UsuarioJson dto = new UsuarioJson(
                null,
                "Outro João",
                "joao@teste.com",
                "654321",
                TIPO_CLIENTE);

        ResponseEntity<String> response =
                restTemplate.postForEntity("/usuarios", dto, String.class);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    @DisplayName("Deve listar usuários")
    void deveListarUsuarios() {

        criarUsuario();

        ResponseEntity<UsuarioJson[]> response =
                restTemplate.getForEntity("/usuarios", UsuarioJson[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        UsuarioJson[] usuarios = response.getBody();

        assertNotNull(usuarios);
        assertEquals(1, usuarios.length);
    }

    @Test
    @DisplayName("Deve buscar usuário por id")
    void deveBuscarUsuarioPorId() {

        UsuarioEntity usuario = criarUsuario();

        ResponseEntity<UsuarioJson> response =
                restTemplate.getForEntity(
                        "/usuarios/{id}",
                        UsuarioJson.class,
                        usuario.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        UsuarioJson json = response.getBody();

        assertNotNull(json);
        assertEquals(usuario.getId(), json.getId());
        assertEquals(usuario.getNome(), json.getNome());
        assertEquals(usuario.getEmail(), json.getEmail());
    }

    @Test
    @DisplayName("Deve retornar 404 ao buscar usuário inexistente")
    void deveRetornar404AoBuscarUsuarioInexistente() {

        ResponseEntity<String> response =
                restTemplate.getForEntity(
                        "/usuarios/{id}",
                        String.class,
                        99999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("Deve deletar usuário")
    void deveDeletarUsuario() {

        UsuarioEntity usuario = criarUsuario();

        restTemplate.delete("/usuarios/{id}", usuario.getId());

        assertFalse(usuarioRepository.existsById(usuario.getId()));
    }

    @Test
    @DisplayName("Deve retornar 404 ao deletar usuário inexistente")
    void deveRetornar404AoDeletarUsuarioInexistente() {

        ResponseEntity<Void> response =
                restTemplate.exchange(
                        "/usuarios/{id}",
                        HttpMethod.DELETE,
                        null,
                        Void.class,
                        99999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("Deve atualizar tipo do usuário")
    void deveAtualizarUsuarioTipo() {

        UsuarioEntity usuario = criarUsuario();

        UsuarioJson update =
                new UsuarioJson(
                        usuario.getId(),
                        TIPO_DONO);

        restTemplate.put(
                "/usuarios/{id}",
                update,
                usuario.getId());

        UsuarioEntity atualizado =
                usuarioRepository.findById(usuario.getId()).orElse(null);

        assertNotNull(atualizado);
        assertEquals(TIPO_DONO, atualizado.getUsuarioTipoId());
    }

    @Test
    @DisplayName("Deve retornar 404 ao atualizar usuário inexistente")
    void deveRetornar404AoAtualizarUsuarioInexistente() {

        UsuarioJson update =
                new UsuarioJson(
                        null,
                        TIPO_DONO);

        ResponseEntity<String> response =
                restTemplate.exchange(
                        "/usuarios/{id}",
                        HttpMethod.PUT,
                        new HttpEntity<>(update),
                        String.class,
                        99999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // ======================================================
    // Helpers
    // ======================================================

    private UsuarioEntity criarUsuario() {

        UsuarioEntity usuario = new UsuarioEntity(
                null,
                "João",
                "joao@teste.com",
                "123456",
                TIPO_CLIENTE);

        return usuarioRepository.save(usuario);
    }
}