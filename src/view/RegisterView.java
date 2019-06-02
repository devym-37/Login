package view;

import front.FrontView;
import front.PageView;
import service.UserService;

import java.util.Scanner;

import static view.ModuleView.bookrent;
import static view.ModuleView.execute_program;

public class RegisterView {
    UserService userService = new UserService();

    public void registerView() {
        Scanner scanner = new Scanner(System.in);

        String id = null;
        String password = null;
        String name = null;
        String email = null;

        System.out.print("\t\t\tCreate Id : ");
        id = scanner.nextLine();

        System.out.print("\t\t\tYour Password : ");
        password = scanner.nextLine();

        System.out.print("\t\t\tYour Name : ");
        name = scanner.nextLine();

        System.out.print("\t\t\tYour E-mail : ");
        email = scanner.nextLine();
        // 1. 결과값 가져오기
        // 2. 중복된 아이디가 있으면 알려주기
        // 3. 중복된 아이디가 없으면 로그인 화면으로 이동
        int response = userService.saveUser(id, password, name, email);          // 1
        if (response == 1) {                                         // 2
            FrontView.existing_ID();
        }
        if (response == 2) {
            FrontView.existing_name();
        }
        if (response == 3) {
            FrontView.existing_email();
        }
        if (response == 0) {                                          // 3
            FrontView.complete_front();
        }

    }


    public void login_View() {
        RegisterView registerView = new RegisterView();
        BookView bookView = new BookView();
        Scanner scanner = new Scanner(System.in);

        String id = null;
        String password = null;

        System.out.print("\t\t\tEnter Your ID : ");
        id = scanner.nextLine();

        System.out.print("\t\t\tEnter Your Password : ");
        password = scanner.nextLine();

        int response = userService.login(id, password);
        switch (response) {
            case 0:
                FrontView.nonId_login(); // id 없음
                registerView.registerView();
                FrontView.login_front();
                registerView.login_View();
                break;
            case 1:
                FrontView.pwderror_front(); // 비밀번호 틀림
                registerView.login_View();
                break;
            case 2:
                FrontView.success_login();  // login 성공
                break;
            case 3:
                FrontView.adminLogin();     // 관리자 모드 login
                bookView.enrollBook();
                break;
            default:
                PageView.inputError();
                break;
        }
    }

    public void logout_User() {
        Scanner scanner = new Scanner(System.in);

        String value = null;
        FrontView.logoutFroont();
        System.out.print("\t\t\tEnter Input key (Y/N) : ");
        value = scanner.nextLine();
        int response = userService.logoutUser(value);
        switch (response) {
            case 0:
                PageView.inputError();
                break;
            case 1:
                FrontView.logoutSuccess();
                execute_program();
                break;
            case 2:
                FrontView.Nonlogout();
                bookrent();
                break;
            default:
                PageView.inputError();
                break;
        }

    }

    public void find_User() {
        Scanner scanner = new Scanner(System.in);

        String name = null;
        String email = null;

        System.out.print("\t\t\tEnter Your Name : ");
        name = scanner.nextLine();

        System.out.print("\t\t\tEnter Your E-mail : ");
        email = scanner.nextLine();

        int findUser = userService.findUser(name, email);
        switch (findUser) {
            case 0:
                FrontView.nonName_login();// 동일한 id/email 없음
                break;
            case 1:             // id/pwd 반환
                break;
            default:
                PageView.inputError();
                break;
        }

    }

    public void remove_User() {
        Scanner scanner = new Scanner(System.in);

        String name = null;
        String id = null;
        String password = null;

        System.out.print("\t\t\tEnter Your Name : ");
        name = scanner.nextLine();

        System.out.print("\t\t\tEnter Your Id : ");
        id = scanner.nextLine();

        System.out.print("\t\t\tEnter Your Password : ");
        password = scanner.nextLine();

        int removeUser = userService.removeUser(name, id, password);
        switch (removeUser) {
            case 0:                     // 입력한 내용의 data가 없음
                FrontView.NonremoveID();
                break;
            case 1:                     // 입력한 data 삭제
                FrontView.removeData();
                break;
            default:
                PageView.inputError();
                break;
        }

    }

}
