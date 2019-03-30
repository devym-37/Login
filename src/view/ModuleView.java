package view;

import front.BookView;
import front.FrontView;

import java.util.Scanner;

public class ModuleView {

    public static void execute_program() {
        RegisterView registerView = new RegisterView();
        int menu_num = 0;
        boolean loop = true;
        while (loop) {
            FrontView.frontDesign();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Number : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 1:
                    FrontView.login_front();
                    registerView.login_View();
                    loop = false;
                    BookView.Bookpage1();
                    break;
                case 2:
                    FrontView.register_front();
                    registerView.registerView();
                    break;
                case 3:                     //find
                    FrontView.find_front();
                    registerView.find_User();
                    break;
                case 4:                     //delete
                    break;
                case 5:
                    FrontView.Off_front();
                    loop = false;
                    break;
                default:
                    FrontView.error_front();
                    break;
            }
        }
    }

    public static void register_pro() {
        RegisterView registerView = new RegisterView();
        int menu_num = 0;
        boolean loop = true;
        while (loop) {
            FrontView.reg_afterfront();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Num : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 1:
                    FrontView.login_front();
                    registerView.login_View();
                    loop = false;
                    BookView.Bookpage1();
                    break;
                case 2:                     //find
                    FrontView.find_front();
                    registerView.find_User();
                    break;
                case 3:                     //delete
                    break;
                case 4:
                    FrontView.Off_front();
                    loop = false;
                    break;
                default:
                    FrontView.error_front();
                    break;
            }
        }
    }


}
