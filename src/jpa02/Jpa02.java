package jpa02;

import dao.ClienteDAO;
import model.Cliente;
import model.Telefone;

/**
 *
 * @author martin_ruediger
 */
public class Jpa02 {
    public static void main(String[] args) {
        Cliente clienteNovo = new Cliente("nome");
        ClienteDAO.save(clienteNovo);
//        for (Cliente cliente : ClienteDAO.findAll()) {
//            System.out.println(cliente.getNome());
//            for (Telefone telefone : cliente.getListaTelefone()) {
//                System.out.println(telefone.getNumero());
//            }
//            System.out.println("");
//        }
        
        Cliente clienteTelefone = ClienteDAO.findById(1);
        clienteTelefone.getListaTelefone().add(new Telefone("40028922", clienteTelefone));
        ClienteDAO.save(clienteTelefone);
        System.exit(0);
    }
    
}
