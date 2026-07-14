package br.com.fiap.techchalleger.restaurantescleanarch.infra.web.json;

public class UsuarioJson {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Long usuarioTipoId;

    public UsuarioJson(Long id, String nome, String email, String senha, Long usuarioTipoId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuarioTipoId = usuarioTipoId;
    }

    public UsuarioJson(Long id, Long usuarioTipoId) {
        this.id = id;
        this.usuarioTipoId = usuarioTipoId;
    }

    public UsuarioJson() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getUsuarioTipoId() {
        return usuarioTipoId;
    }

    public void setUsuarioTipoId(Long usuarioTipoId) {
        this.usuarioTipoId = usuarioTipoId;
    }

}
