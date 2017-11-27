package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author martin_ruediger
 */
@Entity
public class Telefone implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    @ManyToOne
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(int id, String numero, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.cliente = cliente;
    }

    public Telefone(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
}
