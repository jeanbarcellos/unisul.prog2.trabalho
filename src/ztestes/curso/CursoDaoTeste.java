package ztestes.curso;


import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;
import model.dao.DaoFactory;
import model.dao.CursoDao;

public class CursoDaoTeste {

    public static void main(String[] args) {
        
        CursoDao cursoDao = DaoFactory.getDaoFactory().getCursoDao();
//        
//        // Pega todos os objetos do banco
//        List<Curso> cursos = cursoDao.all();
//        
//        String texto = "Cursos Cadastrados:\n";
//        for (int i = 0; i < cursos.size(); i++) {
//            Curso cursoExt = cursos.get(i);
//            texto += "ID: " + cursoExt.getId() + " - ";
//            texto += "Nome: " + cursoExt.getNome() + "  \n";
//        }
//        JOptionPane.showMessageDialog(null, texto);
//
//        
        int last_id = cursoDao.lastId();        
        JOptionPane.showMessageDialog(null, last_id);

        
//        cursoDao.sequenciar();
        
    }

}
