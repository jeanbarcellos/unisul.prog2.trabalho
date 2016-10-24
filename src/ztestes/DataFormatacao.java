package ztestes;

import java.util.Date;
import utils.Data;

public class DataFormatacao {

    public static void main(String[] args) {

        Date data = new Date();
        System.out.println("Data orig: " + data);


        System.out.println("Data Formatada: " + Data.formatar(new Date(), ""));
        System.out.println("Data Formatada: " + Data.formatar(new Date(), "BR_DATA"));
        System.out.println("Data Formatada: " + Data.formatar(new Date(), "BR_HORA"));
    }

}
