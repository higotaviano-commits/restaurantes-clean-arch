
package br.com.fiap.techchalleger.restaurantescleanarch.infra.database.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name="UsuarioTipo")
public class UsuarioTipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;

    public UsuarioTipoEntity(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public UsuarioTipoEntity() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
