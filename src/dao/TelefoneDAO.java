package dao;

import java.util.List;
import model.Telefone;

/**
 *
 * @author martin_ruediger
 */
public class TelefoneDAO {
    
    public static void save(Telefone telefone){
        JpaUtil.getEntityManager().getTransaction().begin();
        if(telefone.getId() == 0){
            JpaUtil.getEntityManager().persist(telefone);
        }else{
            JpaUtil.getEntityManager().merge(telefone);
        }
        JpaUtil.getEntityManager().getTransaction().commit();
    }
    
    public static Telefone findById(int id){
        return JpaUtil.getEntityManager().find(Telefone.class, id);
    }
    
    public static List<Telefone> findAll(){
        return JpaUtil.getEntityManager().createQuery("select c from Telefone c").getResultList();
    }
    
    public static void delete(int id){
        JpaUtil.getEntityManager().remove(JpaUtil.getEntityManager().getReference(Telefone.class, id));
    }
    
    public static void delete(Telefone telefone){
        delete(telefone.getId());
    }
}
