package ztestes.exemplar;

import model.Livro;
import model.Exemplar;
import model.dao.DaoFactory;
import model.dao.ExemplarDao;
import model.dao.LivroDao;

public class ExemplarTesteDao02 {

    public static void main(String[] args) {

        LivroDao livroDao = DaoFactory.getDaoFactory().getLivroDao();
        ExemplarDao exemplarDao = DaoFactory.getDaoFactory().getExemplarDao();

        Livro livro = livroDao.load(1);

        System.out.println(livro);
        
        Exemplar exemplar1 = exemplarDao.load(1);
        
        System.out.println(exemplar1);
        

    }

}
