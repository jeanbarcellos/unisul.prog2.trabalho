/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class SerialTeste {
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        List<Pessoa> lista = new ArrayList<Pessoa>();
        
        Endereco end1 = new Endereco("99999-123", "Frei caneca", "Floripa", "SC");
        Endereco end2 = new Endereco("99999-123", "Castelo Branco", "Bom retiro", "SC");
        Endereco end3 = new Endereco("99999-123", "Fernando Marcos", "Tubrarão", "SC");
        
        lista.add(new Pessoa("Jean Barcellos", end1));
        lista.add(new Pessoa("Maria Silva dos Santos", end2));
        lista.add(new Pessoa("José Pafuncio", end3));
        
        String texto = "";
        for (int i = 0; i < lista.size(); i++) {
            Pessoa pessoa = lista.get(i);
            texto += "Nome: " + pessoa.getNome() + "  \n";
            texto += "Endereço: Cep: " + pessoa.getEndereco().getCep() + " ";
            texto += "Rua: " + pessoa.getEndereco().getCidade()+ "  \n\n";
        }
        System.out.println(texto);
        
    }
    
}
