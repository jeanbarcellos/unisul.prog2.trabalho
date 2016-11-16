package ztestes.livro;


import java.util.List;
import javax.swing.JOptionPane;
import model.Livro;
import model.dao.DaoFactory;
import model.dao.LivroDao;

public class LivroDaoTeste02 {

    public static void main(String[] args) {
        
        /**
         * Retorna uma instancia de PostgresLivroDao;
         * 
         * return LivroDao livroDao = new PostgresLivroDao();
         */
        LivroDao LivroDao = DaoFactory.getDaoFactory().getLivroDao();
        
        Livro livro = LivroDao.load(2);
        
        JOptionPane.showMessageDialog(null, livro);
        
    }

}
