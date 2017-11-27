package dao;

import model.Cliente;

/**
 *
 * @author martin_ruediger
 */
public class ClienteDAO extends AbstractJPAdao<Cliente>{

    public ClienteDAO() {
        SELECT_SQLFINDALL = "select c from cliente c";
    }
    
    @Override
    protected Cliente object() {
        return new Cliente();
    }
    
}
