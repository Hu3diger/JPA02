package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author martin_ruediger
 */
public class ClienteDAO {

    /*
x    findById
    findAll
x    save
    delete id
    delete object
    */
    
    public static void save(Cliente cliente){
        if(cliente.getId() == null){
            JpaUtil.getEntityManager().persist(cliente);
        }else{
            JpaUtil.getEntityManager().merge(cliente);
        }
    }
    
    public static Cliente findById(Long id){
        return JpaUtil.getEntityManager().find(Cliente.class, id);
    }
    
    public static List<Cliente> findAll(){
        return JpaUtil.getEntityManager().createQuery("select c from cliente c").getResultList();
    }
    
    public static void delete(Long id){
        JpaUtil.getEntityManager().remove(JpaUtil.getEntityManager().getReference(Cliente.class, id));
    }
    
    public static void delete(Cliente cliente){
        delete(cliente.getId());
    }
}
