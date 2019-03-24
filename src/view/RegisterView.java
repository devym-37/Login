package view;

import front.ModuleView;
import front.FrontView;
import service.UserService;

import java.util.Scanner;

public class RegisterView {

    UserService userService = new UserService();
    FrontView frontView = new FrontView();
    ModuleView moduleView = new ModuleView();

    public void registerView() {
        Scanner scanner = new Scanner(System.in);

        String id = null;
        String password = null;
        String name = null;
        String email = null;

        System.out.print("Id : ");
        id = scanner.nextLine();

        System.out.print("Pwd : ");
        password = scanner.nextLine();

        System.out.print("Name : ");
        name = scanner.nextLine();

        System.out.print("E-mail : ");
        email = scanner.nextLine();
        // 1. 결과값 가져오기
        // 2. 중복된 아이디가 있으면 알려주기
        // 3. 중복된 아이디가 없으면 로그인 화면으로 이동
        int response = userService.saveUser(id, password, name, email);          // 1
        if (response == -1) {                                         // 2
            frontView.existing_front();
        }
        if (response == 1) {                                          // 3
            frontView.complete_front();
            moduleView.register_pro();

        }

    }


    public void login_View() {
        Scanner scanner = new Scanner(System.in);

        String id = null;
        String password = null;

        System.out.print("ID : ");
        id = scanner.nextLine();

        System.out.print("PWD : ");
        password = scanner.nextLine();

        int response = userService.login(id, password);
        switch (response) {
            case 0:
                frontView.nonId_login(); // id 없음
                frontView.register_front();    // register 화면 출력
                break;
            case 1:
                frontView.pwderror_front(); // 비밀번호 틀림
                frontView.login_front();    // login화면 재출력
                break;
            case 2:
                frontView.success_login();  // login 성공
                break;
        }
    }

    public void find_User(){
        Scanner scanner = new Scanner(System.in);

        String name = null;
        String email = null;

        System.out.print("Name : ");
        name = scanner.nextLine();

        System.out.print("E-mail : ");
        email = scanner.nextLine();

        int findUser = userService.findUser(name, email);

    }

}
