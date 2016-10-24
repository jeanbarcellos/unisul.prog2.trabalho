package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    static public String formatar(Date data, String formatoSaida) {
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
            default:
                formato = "dd/MM/yyyy HH:mm:ss";

        }

        SimpleDateFormat fmt = new SimpleDateFormat(formato);
        dataFormadata = fmt.format(data);

        return dataFormadata;
    }

}
