import front.FrontView;
import front.ModuleView;


public class EntryPoint {

    public static void main(String[] args) {

        ModuleView moduleView = new ModuleView();
        FrontView frontView = new FrontView();

        moduleView.execute_program();

    }

}
