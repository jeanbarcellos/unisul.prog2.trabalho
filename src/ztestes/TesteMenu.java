/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class TesteMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("Bem-vindo");
// Definindo margem superior, esquerda, largura e altura e altura respectivamente
        frame.setBounds(200, 100, 300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Criando um layout do tipo FlowLayout
        FlowLayout layout = new FlowLayout();

        Container caixa = frame.getContentPane();
        caixa.setLayout(layout);

        for (int i = 1; i <= 10; i++) {
            caixa.add(new JButton("Botão " + i));
        }

    }

}
