package dao;

import java.util.List;
import model.Entity;

/**
 *
 * @author martin_ruediger
 */
public abstract class AbstractJPAdao<T extends Entity> implements IDao<T>{
    
    protected String SELECT_SQLFINDALL;
    
    @Override
     public void save(T object){
        JpaUtil.getEntityManager().getTransaction().begin();
        if(object.getId() == 0){
            JpaUtil.getEntityManager().persist(object);
        }else{
            JpaUtil.getEntityManager().merge(object);
        }
        JpaUtil.getEntityManager().getTransaction().commit();
    }
    
    @Override
    public T findById(int id){
        return JpaUtil.getEntityManager().find((Class<T>)object().getClass(), id);
    }
    
    @Override
    public List<T> findAll(){
        return JpaUtil.getEntityManager().createQuery(SELECT_SQLFINDALL).getResultList();
    }
    
    @Override
    public void delete(int id){
        JpaUtil.getEntityManager().remove(JpaUtil.getEntityManager().getReference((Class<T>)object().getClass(), id));
    }
    
    @Override
    public void delete(T object){
        delete(object.getId());
    }
    
    protected abstract T object();
    
}
