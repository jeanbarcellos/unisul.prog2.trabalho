
import javax.swing.JOptionPane;

public class Teste01 {

    public static void main(String[] args) {
        Object[] opcoes = {"sim", "não"};
        Object resposta;

//        resposta = JOptionPane.showInputDialog(null,
//                "Deseja finalizar o programa?",
//                "Finalização",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                opcoes,
//                "não");
        
        resposta = JOptionPane.showInputDialog(null, 
                "MENU \n",
                "Título",
                JOptionPane.QUESTION_MESSAGE
            );
    }
}
