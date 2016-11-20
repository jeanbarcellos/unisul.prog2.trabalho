/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztestes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import util.Data;

/**
 *
 * @author Jean Barcellos
 */
public class TesteData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Calendar calendar = Calendar.getInstance();
//        Date data = calendar.getTime();
//        
//        System.out.println(data);
//        
//        data.setDate(data.getDate() + 1);
//        System.out.println(data);
//        Date a = new Date("2004/09/01");
//        data.set(Calendar.DAY_OF_MONTH, +1);
//        
//        System.out.println(data.getTime());
//        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
//
//        Calendar c = new GregorianCalendar(2004, 9, 2);
//
//        System.out.println("Data: " + sd.format(c.getTime()));
//
//        c.add(Calendar.DAY_OF_MONTH, 60);
//        System.out.println("Sessenta dias depois: " + sd.format(c.getTime()));
//
//        c.add(Calendar.DAY_OF_MONTH, -1);
//        System.out.println("Um dia antes: " + sd.format(c.getTime()));
//
//        c.add(Calendar.MONTH, -1);
//        System.out.println("Um mês antes: " + sd.format(c.getTime()));
//
//        c = new GregorianCalendar(2003, Calendar.MARCH, 3);
//        System.out.println("Data: " + sd.format(c.getTime()));
//
//        c.add(Calendar.DAY_OF_MONTH, -1);
//        System.out.println("Um dia antes: " + sd.format(c.getTime()));
//
//        c.add(Calendar.MONTH, -1);
//        System.out.println("Um mês antes: " + sd.format(c.getTime()));
//
        int minuto = 1000 * 60;
        int hora = minuto * 60;
        long dia = hora * 24;
        long years = dia * 365;
        
        
        Date dataAgora = new Date();               
        Date dataFutura = new Date();        
        dataFutura.setTime(dataAgora.getTime() + (1 * dia));

        System.out.println(dataAgora);
        System.out.println(dataFutura);
        
        
//        
//        Date dataAgora = new Date();
//        dataAgora.setTime(0);
        
//        Date dataProx = dataAgora.setTime();
        
//        System.out.println(dataAgora.getTime());
        
    }

    
    
  
}
