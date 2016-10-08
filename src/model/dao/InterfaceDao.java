package model.dao;

/**
 * Interface DAO
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public interface InterfaceDao {

    public abstract void insert(Object obj);

    public abstract void update(Object objeto);

    public abstract void delete(Object objeto);

    public abstract void getAll();

    public abstract void getObject(int id);

}
