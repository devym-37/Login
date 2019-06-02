package view;

import front.FrontView;
import front.PageView;

import java.util.Scanner;

public class ModuleView {


    public static void execute_program() {
        RegisterView registerView = new RegisterView();
        BookView bookView = new BookView();
        int menu_num = 0;
        boolean loop = true;

        while (loop) {
            FrontView.frontDesign();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("\t\t\tSelect Number : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 0:
                    bookView.currentBookView();
                    register_pro();
                    loop = false;
                    break;
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
            System.out.print("\t\t\tSelect Number : ");
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
        RentView rentView = new RentView();
        RegisterView registerView = new RegisterView();
        int menu_num = 0;
        boolean loop = true;

        while (loop) {
            PageView.Bookpage1();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("\t\t\tSelect Number : ");
            menu_num = SelectNum.nextInt();
            switch (menu_num) {
                case 0:                 // book list
                    bookView.currentBookView();
                    returnlistView();                   //rent service
                    loop = false;
                    break;
                case 1:                 // rentable booklist
                    bookView.rentalList();
                    returnlistView();
                    break;
                case 2:                 // onloan booklist
                    bookView.onloanList();
                    returnlistView();
                    break;
                case 3:                 // book search
                    searchbook();
                    searchRentView();
                    rentView();
                    break;
                case 4:                 // book borrow
                    rentView.curr_rentView();
                    break;
                case 5:                 // return book
                    rentView.returnbook();
                    break;
                case 6:
                    registerView.logout_User();
                    break;
                default:
                    FrontView.error_front();
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
            System.out.print("\t\t\tSelect Number : ");
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

    public static void rentView(){
        BookView bookView = new BookView();
        RentView rentView = new RentView();
        RegisterView registerView = new RegisterView();
        int menuNum = 0;
        boolean loop = true;
        while(loop){
            PageView.rentpage2();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("\t\t\tSelect Number : ");
            menuNum = SelectNum.nextInt();
            switch (menuNum){
                case 1:             // bookrent;
                    rentView.rentbook();
                    break;
                case 2:
                    registerView.logout_User();
                    break;
                default:
                    PageView.inputError();
                    break;
            }
        }
    }

    public static void returnlistView() {
        BookView bookView = new BookView();
        int menuNum = 0;
        boolean loop = true;

        while (loop) {
            PageView.rentpage1();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("\t\t\tSelect Number : ");
            menuNum = SelectNum.nextInt();
            switch (menuNum) {
                case 1:
                    bookrent();
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
        RentView rentView = new RentView();
        int menuNum = 0;
        boolean loop = true;

        while (loop) {
            PageView.rentpage2();
            Scanner SelectNum = new Scanner(System.in);
            System.out.print("\t\t\tSelect Number : ");
            menuNum = SelectNum.nextInt();
            switch (menuNum) {
                case 1:                 // rent a book();
                    rentView.rentbook();
                    break;
                case 2:
                    bookView.currentBookView();
                    break;
                default:
                    PageView.inputError();
                    break;
            }
        }
    }


}
