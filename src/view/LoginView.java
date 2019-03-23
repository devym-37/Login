package view;

import service.UserService;

import java.util.Scanner;

public class LoginView {

    UserService userService = new UserService();

    public void registerView(){
        Scanner scanner = new Scanner(System.in);

        String id = null;
        String password = null;

            System.out.print("ID : ");
            id = scanner.nextLine();

            System.out.print("PWD : ");
            password = scanner.nextLine();

            userService.saveUser(id, password);

    }

}
