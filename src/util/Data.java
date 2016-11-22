package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe Data
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 23/10/2016
 *
 * @package utils
 *
 */
public class Data {

    public static String formatar(java.util.Date data, String formatoSaida) {
        String dataFormadata;
        String formato;

        switch (formatoSaida) {
            case "BR_DATAHORA":
                formato = "dd/MM/yyyy HH:mm:ss";
                break;
            case "BR_DATA":
                formato = "dd/MM/yyyy";
                break;
            case "BR_HORA":
                formato = "HH:mm:SS";
                break;
            case "DB_DATAHORA":
                formato = "yyyy-MM-dd HH:mm:SS";
                break;
            case "DB_DATA":
                formato = "yyyy-MM-dd";
                break;
            default:
                formato = "dd/MM/yyyy HH:mm:ss";

        }

        SimpleDateFormat fmt = new SimpleDateFormat(formato);
        dataFormadata = fmt.format(data);

        return dataFormadata;
    }

    public static java.util.Date dataAtual() {
        return Calendar.getInstance().getTime();
    }

    public static java.sql.Date setDataSql(java.util.Date data) {
        java.util.Date dataUtil = data;
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        return dataSql;
    }

    public static java.util.Date somaDias(java.util.Date data, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, dias);
        return cal.getTime();
    }

    public static java.sql.Date sqlDataAtual() {
        java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
//        java.sql.Date dataAtual = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return dataAtual;
    }

    public static java.sql.Date sqlSomarDias(java.sql.Date data, int qtdDas) {
        int minuto = 1000 * 60;
        int hora = minuto * 60;
        long dia = hora * 24;
        long diS2 = ((1000 * 60) * 60) * 24;

        java.sql.Date dataPrevisao = new java.sql.Date(data.getTime() + (qtdDas * dia));

        return dataPrevisao;
    }

}
