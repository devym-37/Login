package view;

import service.UserService;

import java.util.Scanner;

public class RegisterView {

    UserService userService = new UserService();

    public void registerView() {
        Scanner scanner = new Scanner(System.in);

        String id = null;
        String password = null;

        System.out.print("ID : ");
        id = scanner.nextLine();

        System.out.print("PWD : ");
        password = scanner.nextLine();

        // 1. 결과값 가져오기
        // 2. 중복된 아이디가 있으면 알려주기
        // 3. 중복된 아이디가 없으면 로그인 화면으로 이동
        int response = userService.saveUser(id, password);          // 1
        if (response == -1) {                                         // 2
            System.out.println("중복");
        }
        if (response == 1) {                                          // 3
            resView();
        }


    }

    public void resView() {
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
                System.out.println("0");
                // id 없음
                break;
            case 1:
                System.out.println("1");
                // 비밀번호 틀림
                break;
            case 2:
                System.out.println("2");
                // 로그인 성공
                break;
        }
    }

}
