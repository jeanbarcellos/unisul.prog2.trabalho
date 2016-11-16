package ztestes.livro;


import java.util.List;
import javax.swing.JOptionPane;
import model.Livro;
import model.dao.DaoFactory;
import model.dao.LivroDao;

public class LivroDaoTeste01 {

    public static void main(String[] args) {
        
        /**
         * Retorna uma instancia de PostgresLivroDao;
         * 
         * return LivroDao livroDao = new PostgresLivroDao();
         */
        LivroDao LivroDao = DaoFactory.getDaoFactory().getLivroDao();
        
        // Pega todos os objetos do banco
        List<Livro> livros = LivroDao.all();
        
        String texto = "Livros Cadastrados:\n";
        for (int i = 0; i < livros.size(); i++) {
            Livro livroExt = livros.get(i);
            texto += "ID: " + livroExt.getId() + " - ";
            texto += "Nome: " + livroExt.getTitulo() + "  \n";
        }
        JOptionPane.showMessageDialog(null, texto);

        
        int last_id = LivroDao.lastId();
        
        JOptionPane.showMessageDialog(null, last_id);
        
    }

}