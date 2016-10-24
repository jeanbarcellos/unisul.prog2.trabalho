/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import utils.Log;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class LogTeste01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            throw new Exception("Testando");
        } catch (Exception ex) {
            Log.write(ex.getMessage());
        }

    }

}
