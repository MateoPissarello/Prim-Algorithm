package App;
import CONTROLLERS.ControllerMain;
import VIEWS.mainView;

public class Main {
    public static void main(String[] args){
        ControllerMain controllerPrim = new ControllerMain(new mainView());
    }
}
