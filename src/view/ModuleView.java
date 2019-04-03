package view;

import front.FrontView;
import front.PageView;

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
                    FrontView.removefront();
                    registerView.remove_User();
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
                    break;
                case 2:                     //find
                    FrontView.find_front();
                    registerView.find_User();
                    break;
                case 3:                     //delete
                    FrontView.removefront();
                    registerView.remove_User();
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

    public static void bookrent() {
        BookView bookView = new BookView();
        int menu_num = 0;
        boolean loop = true;
        PageView.Bookpage1();
        while (loop) {
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Num : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 1:                 // book list
                    bookView.currentBookView();
                    //rent service
                    break;
                case 2:                 // book search
                    searchbook();
                    break;
                case 3:                 // book borrow
                    break;
                case 4:
                    break;
            }
        }
    }

    public static void searchbook() {
        BookView bookView = new BookView();
        int menu_num = 0;
        boolean loop = true;

        while (loop) {
            PageView.searchpage();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Num : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 1:         // 저자로 검색
                    bookView.search_Writer();
                    break;
                case 2:         // 책이름으로 검색
                    bookView.search_Bookname();
                    break;
                default:
                    System.out.println("┌─────────────────────────────────────────────────────────────┐");
                    System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t   Input Error  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
                    System.out.println("└─────────────────────────────────────────────────────────────┘");
                    break;
            }
        }
    }


}
