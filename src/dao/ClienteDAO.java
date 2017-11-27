package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author martin_ruediger
 */
public class ClienteDAO {

    public static void save(Cliente cliente){
        JpaUtil.getEntityManager().getTransaction().begin();
        if(cliente.getId() == 0){
            JpaUtil.getEntityManager().persist(cliente);
        }else{
            JpaUtil.getEntityManager().merge(cliente);
        }
        JpaUtil.getEntityManager().getTransaction().commit();
    }
    
    public static Cliente findById(int id){
        return JpaUtil.getEntityManager().find(Cliente.class, id);
    }
    
    public static List<Cliente> findAll(){
        return JpaUtil.getEntityManager().createQuery("select c from Cliente c").getResultList();
    }
    
    public static void delete(int id){
        JpaUtil.getEntityManager().remove(JpaUtil.getEntityManager().getReference(Cliente.class, id));
    }
    
    public static void delete(Cliente cliente){
        delete(cliente.getId());
    }
}
