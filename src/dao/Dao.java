package dao;


/**
 * Classe Dao
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 10/09/2016
 *
 * @package dao
 *
 */
public abstract class Dao implements InterfaceDao {

    protected final String conn;

    public Dao() {
        this.conn = "Inicializa a conexão;";
    }
        
    public String getConn() {
        return conn;
    }    
            
    public void insert(Object obj) {
        System.out.println("SQL Insert");
    }

    public void update(Object obj) {
        System.out.println("SQL Update");
    }

    public void delete(Object obj) {
        System.out.println("SQL Delete");
    }

    public void getAll() {
        System.out.println("SQL Select");
    }

    public void getObject(int id) {
        System.out.println("SQL Select com Where");
    }

}
