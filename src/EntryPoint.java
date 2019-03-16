import model.UserModel;
import view.LoginView;

public class EntryPoint {

    public static void main(String[] args) {

//        UserModel mini = new UserModel("mini", "0909");
//
//        System.out.println("[ USER MODEL ]");
//        System.out.println(mini.toString());

        LoginView loginView = new LoginView();
        loginView.registerView();

    }
}
