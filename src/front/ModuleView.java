package front;

import view.RegisterView;
import java.util.Scanner;

public class ModuleView {

    FrontView frontView = new FrontView();
    RegisterView registerView = new RegisterView();

    public void execute_program() {

        int menu_num = 0;
        boolean loop = true;
        while (loop) {
            frontView.frontDesign();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Number : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 1:
                    frontView.login_front();
                    registerView.login_View();
                    break;
                case 2:
                    frontView.register_front();
                    registerView.registerView();
                    break;
                case 3:                     //find
                    break;
                case 4:                     //delete
                    break;
                case 5:
                    frontView.Off_front();
                    loop = false;
                    break;
                default:
                    frontView.error_front();
                    break;
            }
        }
    }

    public void register_pro() {
        int menu_num = 0;
        boolean loop = true;
        while (loop) {
            frontView.reg_afterfront();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Num : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 1:
                    frontView.login_front();
                    registerView.login_View();
                    break;
                case 2:                     //find
                    break;
                case 3:                     //delete
                    break;
                case 4:
                    frontView.Off_front();
                    loop = false;
                    break;
                default:
                    frontView.error_front();
                    break;
            }
        }
    }


}
