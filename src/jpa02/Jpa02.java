package jpa02;

import dao.ClienteDAO;
import model.Cliente;

/**
 *
 * @author martin_ruediger
 */
public class Jpa02 {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1L, "nome");
        ClienteDAO.save(cliente);
    }
    
}
