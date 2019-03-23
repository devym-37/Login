import front.frontView;
import service.FilterUser;
import view.LoginView;
import java.util.Scanner;


public class EntryPoint {

    public static void main(String[] args) {

        LoginView loginView = new LoginView();
        frontView frontView = new frontView();
        FilterUser filterUser = new FilterUser();

        int menu_num = 0;
        boolean loop = true;
        while(loop){
            frontView.frontDesign();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Number : ");
            menu_num = SelectNum.nextInt();
            switch(menu_num){
                case 1:
                    frontView.step1_front();
                    loginView.registerView();
                    break;
                case 2:
                    frontView.step2_front();
                    filterUser.getUserRepository();
                    frontView.register_front();
                    break;
                case 3:
                    break;
                case 4:
                    frontView.step4_front();
                    loop = false;
                    break;
                default:
                    frontView.error_front();
                    break;
            }

        }

        // loginView.registerView();







    }

}
