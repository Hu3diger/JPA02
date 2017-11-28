package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Martin.Ruediger
 */
public abstract class AbstractJPADao<T extends IEntity> implements IDao<T>{

    private Class<T> clazz;

    public AbstractJPADao() {
        clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];;
    } 

    public void save(T t) {
        JpaUtil.getEntityManager().getTransaction().begin();
        if (t.getId() == 0) {
            JpaUtil.getEntityManager().persist(t);
        } else {
            JpaUtil.getEntityManager().merge(t);
        }
        JpaUtil.getEntityManager().getTransaction().commit();
    }

    public T findById(int id) {
        return JpaUtil.getEntityManager().find(clazz, id);
    }

    public List<T> findAll() {
        return JpaUtil.getEntityManager()
                .createQuery("select c from "+clazz.getSimpleName()+"c")
                .getResultList();
    }

    public void delete(int id) {
        JpaUtil.getEntityManager().remove(
                JpaUtil.getEntityManager()
                .getReference(clazz, id));
    }

    public void delete(T t) {
        delete(t.getId());
    }

}
