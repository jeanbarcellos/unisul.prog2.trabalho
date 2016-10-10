
import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;
import model.dao.DaoFactory;
import model.dao.CursoDao;

public class TesteDao01 {

    public static void main(String[] args) {
        
        /**
         * Retona uma instancia de PostgresDaoFactory 
         * ou de ArquivoDaoFactory
         * 
         * return DaoFactory dao = new PostgresDaoFactory();
         */
        DaoFactory dao = DaoFactory.getDaoFactory();
        
        /**
         * Retorna uma instancia de PostgresCursoDao;
         * 
         * return CursoDao cursoDao = new PostgresCursoDao();
         */
        CursoDao cursoDao = dao.getCursoDao();
        
        // Pega todos os objetos do banco
        List<Curso> cursos = cursoDao.all();
        
        String texto = "Cursos Cadastrados:\n";
        for (int i = 0; i < cursos.size(); i++) {
            Curso cursoExt = cursos.get(i);
            texto += "ID: " + cursoExt.getId() + " - ";
            texto += "Nome: " + cursoExt.getNome() + "  \n";
        }
        JOptionPane.showMessageDialog(null, texto);

    }

}
