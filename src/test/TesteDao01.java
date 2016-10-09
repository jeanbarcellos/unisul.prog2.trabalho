
import model.dao.DaoFactory;
import model.dao.CursoDao;

public class TesteDao01 {

    public static void main(String[] args) {

        DaoFactory dao = DaoFactory.getDaoFactory();
        
        CursoDao CursoDao = dao.getCursoDao();
        
        CursoDao.listar();

    }

}
