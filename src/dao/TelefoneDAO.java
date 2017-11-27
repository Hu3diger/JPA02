package dao;

import java.util.List;
import model.Telefone;

/**
 *
 * @author martin_ruediger
 */
public class TelefoneDAO extends AbstractJPAdao<Telefone>{

    public TelefoneDAO() {
        SELECT_SQLFINDALL = "select c from telefone c";
    }

    @Override
    protected Telefone object() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
