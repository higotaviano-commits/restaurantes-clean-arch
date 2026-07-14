package br.com.fiap.techchalleger.restaurantescleanarch.core.dto;

public class CriarUsuarioDto {

    private String nome;
    private String email;
    private String senha;
    private Long usuarioTipoId;

    public CriarUsuarioDto(String nome, String email, String senha, Long usuarioTipoId) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuarioTipoId = usuarioTipoId;
    }

    public CriarUsuarioDto() {}

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Long getUsuarioTipoId() {
        return usuarioTipoId;
    }

}
