package ztestes.exemplar;

import java.util.List;
import javax.swing.JOptionPane;
import model.Exemplar;
import model.Livro;
import model.dao.DaoFactory;
import model.dao.ExemplarDao;

public class ExemplarDao02 {

    public static void main(String[] args) {

        ExemplarDao exemplarDao = DaoFactory.getDaoFactory().getExemplarDao();

        // CONTADOR ------------------------------------------------------------
        
//        int proxId = exemplarDao.lastId() + 1;
//        
//        System.out.println(proxId);
        

        // LOAD ----------------------------------------------------------------
//        Exemplar retorno1 = exemplarDao.load(1);
//        System.out.println(retorno1);
//        
//        if (retorno1 != null) {
//            System.out.println(retorno1);
//        } else {
//            System.out.println("NÃO");
//        }

        // INSERIR -------------------------------------------------------------
        
//        Exemplar ex1 = new Exemplar();
//        ex1.setId(1);
//        ex1.setLivro(new Livro(1, "Livro 1", "Autor 2"));
//        ex1.setEdicao("Edição 1");
//        ex1.setLocalizacao("Autor 2");
//
//        boolean retrono = exemplarDao.insert(ex1);
//
//        if (retrono) {
//            JOptionPane.showMessageDialog(null, "Exemplar incluído com sucesso.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao tentar incluir exemplar.");
//        }

        // LISTAR --------------------------------------------------------------
        List<Exemplar> retorno4 = exemplarDao.all();
        
        for (Exemplar exem : retorno4) {
            System.out.println(exem);
        }        

    }

}
