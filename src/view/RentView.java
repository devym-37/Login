package view;

import front.PageView;
import model.RentModel;
import repository.UserRepository;
import service.RentService;

import java.util.List;
import java.util.Scanner;

public class RentView {

    public void curr_rentView(){
        UserRepository rentRepository = new UserRepository();
        List<RentModel> rentmodel = rentRepository.findrent();

        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\tBook List\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\tBorrower\t\t\t\t\t\tWriter\t\t\t\t\t\t\t\tBook Name\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");


        for(int i = 0; i < rentmodel.size(); i++){
            Object list = rentmodel.get(i);
            System.out.printf("\t\t\t\t\t%-10s            \t\t\t%s\t\t\t\t\t\t%s\t\t\t%n",
                    ((RentModel) list).getId(), ((RentModel) list).getWriter(), ((RentModel) list).getBookName());
        }
    }

    public void rentbook() {
        RentService rentService = new RentService();
        Scanner scanner = new Scanner(System.in);
        String value = null;

        System.out.print("\t\t\tWill you borrow this book ? (Y/N) : ");
        value = scanner.nextLine();
        int response = rentService.rentBook(value);
        switch (response){
            case 0:             //  default
                PageView.inputError();
                break;
            case 1:             // rent
                ModuleView.bookrent();
                break;
            case 2:             // back
                ModuleView.bookrent();
                break;
        }

    }

    public void returnbook(){

    }

}
