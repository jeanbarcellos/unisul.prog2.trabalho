/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class TimestampTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
//        Timestamp timestamp = new Timestamp());
        System.err.println(dataDeHoje);
    }
    
}
