/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes.usuario;

import control.ExemplarControl;
import java.util.List;
import model.Exemplar;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class ExemplarTEste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ExemplarControl control = new ExemplarControl();
        
        List<Exemplar> lista = control.buscarPeloTitulo("Livro");
                
        System.out.println(lista);
        
        
        
        // TODO code application logic here
    }
    
}
