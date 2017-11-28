package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import dao.IEntity;

/**
 *
 * @author Martin.Ruediger
 */

@Entity
public class Cliente implements IEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    
    
    
    
    
}
