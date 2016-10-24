package ztestes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTeste {

    public static void main(String[] args) {

        Date data = new Date();
        
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormat = fmt.format(data);

        System.out.println("Data orig: " + data);
        System.out.println("Data Format: " + dataFormat);
    }

}
