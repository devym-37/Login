package view;

import front.PageView;
import model.RentModel;
import model.UserModel;
import repository.UserRepository;
import service.RentService;

import java.util.List;
import java.util.Scanner;

public class RentView {

    public void curr_rentView() {
        UserRepository rentRepository = new UserRepository();
        List<RentModel> rentmodel = rentRepository.findrent();

        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\tBook List\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\tBorrower\t\t\t\t\t\tWriter\t\t\t\t\t\t\t\tBook Name\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");


        for (int i = 0; i < rentmodel.size(); i++) {
            Object list = rentmodel.get(i);
            System.out.printf("\t\t\t\t\t%-10s            \t\t\t%-10s\t\t\t\t%s\t\t\t%n",
                    ((RentModel) list).getId(), ((RentModel) list).getWriter(), ((RentModel) list).getBookName());
        }
    }

    public void currRentedview() {
        UserRepository rentRepository = new UserRepository();
        List<RentModel> currrentmodel = rentRepository.findrent();
        UserModel currentUserModel = rentRepository.currentUser();

        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\tBook List\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\tWriter\t\t\t\t\t\t\t\tBook Name\t\t\t\t\t\t\t\t\tISBN\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");


        for (int i = 0; i < currrentmodel.size(); i++) {
            if (currrentmodel.get(i).getId().equals(currentUserModel.getId())) {
                Object list = currrentmodel.get(i);
                System.out.printf("\t\t\t\t%-10s           \t%-20s\t\t\t\t\t%-20s\t\t\t%n",
                        ((RentModel) list).getWriter(), ((RentModel) list).getBookName(), ((RentModel) list).getIsbn());
            }
        }


    }

    public void rentbook() {
        RentService rentService = new RentService();
        Scanner scanner = new Scanner(System.in);
        String value = null;

        System.out.print("\t\t\tWill you borrow this book ? (Y/N) : ");
        value = scanner.nextLine();
        int response = rentService.rentBook(value);
        switch (response) {
            case 0:             //  default
                PageView.inputError();
                break;
            case 1:             // rent success
                PageView.rentsuccess();
                ModuleView.bookrent();
                break;
            case 2:             // back
                ModuleView.bookrent();
                break;
            default:
                PageView.inputError();
                break;
        }

    }

    public void returnbook() {
        RentService rentService = new RentService();
        Scanner scanner = new Scanner(System.in);
        String value = null;


        PageView.returnpage1();

        System.out.print("\t\t\twill you return this book ? (Y/N) : ");
        value = scanner.nextLine();


        int response = rentService.returnBook(value);
        switch (response) {
            case 0:
                PageView.inputError();
                break;
            case 1:                         // 반납성공
                PageView.returnsuccess();
                ModuleView.bookrent();
                break;
            case 2:                         // 반납안함
                ModuleView.bookrent();
                break;
            default:
                PageView.inputError();
                break;
        }
    }

}
