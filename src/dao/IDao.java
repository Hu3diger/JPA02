package dao;

import java.util.List;

/**
 *
 * @author Martin.Ruediger
 */
public interface IDao<T>{

    public void save(T t);
    public T findById(int id);
    public List<T> findAll();
    public void delete(T t);

}
