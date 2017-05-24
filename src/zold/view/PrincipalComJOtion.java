package zold.view;


/**
 * MenuPrincipalView principal do Software
 *
 * @author Jean Barcellos <jeanbarcellos@hotmail.com>
 */
public class PrincipalComJOtion {

    public static void sair(){
        System.exit(0);
    }
    
    public static void main(String[] args) {
        new MenuPrincipalView().show();
    }

}
