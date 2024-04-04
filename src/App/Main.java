package App;

import CONTROLLERS.ControllerMain;
import VIEWS.mainView;

/**
 * La clase Main es el punto de entrada de la aplicación.
 * Crea una instancia de ControllerMain y le pasa una nueva mainView.
 */
public class Main {
    /**
     * El metodo main es el punto de entrada de la aplicación Java.
     * @param args Un array de argumentos de línea de comandos para la aplicación.
     */
    public static void main(String[] args){
        // Crea una nueva instancia de ControllerMain y le pasa una nueva mainView
        ControllerMain controllerPrim = new ControllerMain(new mainView());
    }
}