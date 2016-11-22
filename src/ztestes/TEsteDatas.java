/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import java.util.Date;
import util.Data;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class TEsteDatas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Date dataAtual = Data.dataAtual();

        String data = Data.formatar(dataAtual, "BR_DATA");
               
        System.out.println(data);
    }
    
}
