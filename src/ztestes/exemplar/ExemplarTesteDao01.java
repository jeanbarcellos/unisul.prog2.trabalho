
package ztestes.exemplar;

import java.util.List;
import model.Exemplar;
import model.dao.DaoFactory;
import model.dao.ExemplarDao;


public class ExemplarTesteDao01 {

    public static void main(String[] args) {

        ExemplarDao exemplarDao = DaoFactory.getDaoFactory().getExemplarDao();        
        
        List<Exemplar> lista = exemplarDao.listar(1);
        
        System.out.println(lista);
    }
    
}
