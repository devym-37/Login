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
                    bookrent();
                    loop = false;
                    break;
                case 2:
                    FrontView.register_front();
                    registerView.registerView();
                    register_pro();
                    loop = false;
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
                    bookrent();
                    loop = false;
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

        while (loop) {
            PageView.Bookpage1();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Num : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 1:                 // book list
                    bookView.currentBookView();
                    rentView();                   //rent service
                    loop = false;
                    break;
                case 2:                 // rentable booklist
                    bookView.rentalList();
                    searchRentView();
                    break;
                case 3:                 // book search
                    searchbook();
                    searchRentView();
                    break;
                case 4:                 // book borrow
                    break;
                case 5:
                    break;
                default:
                    PageView.inputError();
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
                    searchRentView();
                    break;
                case 2:         // 책이름으로 검색
                    bookView.search_Bookname();
                    searchRentView();
                    break;
                default:
                    PageView.inputError();
                    break;
            }
        }
    }

    public static void rentView() {
        BookView bookView = new BookView();
        int menuNum = 0;
        boolean loop = true;

        while (loop) {
            PageView.rentpage1();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Num : ");
            menuNum = SelectNum.nextInt();
            switch (menuNum) {
                case 1:
                    bookView.rentalList();
                    break;
                case 2:
                    FrontView.Off_front();
                    loop = false;
                    break;
                default:
                    PageView.inputError();
                    break;
            }
        }
    }


    public static void searchRentView() {
        BookView bookView = new BookView();
        int menuNum = 0;
        boolean loop = true;

        while (loop) {
            PageView.rentpage2();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("Select Num : ");
            menuNum = SelectNum.nextInt();
            switch (menuNum) {
                case 1:
                    break;
                case 2:
                    bookView.currentBookView();
                    PageView.rentpage1();
                    break;
                default:
                    PageView.inputError();
                    break;
            }
        }
    }


}
