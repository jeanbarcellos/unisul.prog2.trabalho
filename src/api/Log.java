package api;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Log
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 * @date 11/09/2016
 *
 * @package api
 *
 */
public class Log {

    public static void gravar(String mensagem) {

        OutputStream escritorByte = null;
        OutputStreamWriter escritorCaracter = null;
        BufferedWriter escritorPalavras = null;

        try {
            escritorByte = new FileOutputStream("conteudo/log_error.txt", true);
            escritorCaracter = new OutputStreamWriter(escritorByte);
            escritorPalavras = new BufferedWriter(escritorCaracter);
            
            Date data = new Date();            
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");            
            
            String msg = formatador.format(data) + " :: " + mensagem;            
            
            escritorPalavras.write(msg);
            escritorPalavras.newLine();
            escritorPalavras.flush();

        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {

        } finally {
            try {
                if (escritorPalavras != null) {
                    escritorPalavras.close();
                }
                if (escritorCaracter != null) {
                    escritorCaracter.close();
                }
                if (escritorByte != null) {
                    escritorByte.close();
                }
            } catch (Exception e) {
            }
        }

    }
}
