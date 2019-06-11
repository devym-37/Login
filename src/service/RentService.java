package service;

import model.BookModel;
import model.RentModel;
import model.UserModel;
import repository.BookRepository;
import repository.RentRepository;
import repository.UserRepository;
import view.PageView;

import java.util.List;
import java.util.Scanner;

public class RentService {
    RentRepository rentRepository = new RentRepository();
    BookRepository bookRepository = new BookRepository();
    UserRepository userRepository = new UserRepository();

    public int saveRent(String Id, String Writer, String BookName, String Amount, String Isbn) {
        List<RentModel> check_rent = rentRepository.findrent();
        RentModel newRent = new RentModel(Id, Writer, BookName, Amount, Isbn);
        rentRepository.saveRent(newRent);
        return 1;
    }

    public int rentValue(String value) {
        String Value = "Y";
        String nonValue = "N";

        if (Value.equalsIgnoreCase(value.toLowerCase())) {
            return 1;
        } else if (nonValue.equalsIgnoreCase(value.toLowerCase())) {
            return 2;
        }
        return 0;
    }


    public void rentBook() {

        List<BookModel> booklist = bookRepository.findbook();
        UserModel currentUserModel = userRepository.currentUser();

        String Amount = "0";
        String rentAmount = "1";
        String State = "On loan";
        String rentIsbn = null;
        String rentWriter = null;

        Scanner scanner = new Scanner(System.in);

        PageView.rentpage3();
        System.out.print("\t\t\tEnter the Writer of the book you want to rent : ");
        rentWriter = scanner.nextLine();
        System.out.print("\t\t\tEnter the ISBN of the book you want to rent : ");
        rentIsbn = scanner.nextLine();

        for (BookModel bookModel : booklist) {
            if (!bookModel.getState().equals(State) && bookModel.getIsbn().contains(rentIsbn)
            && bookModel.getWriter().contains(rentWriter)) {
                RentModel rentModel = new RentModel();
                rentModel.setId(currentUserModel.getId());
                rentModel.setWriter(bookModel.getWriter());
                rentModel.setBookName(bookModel.getBookName());
                rentModel.setIsbn(bookModel.getIsbn());
                rentModel.setAmount(rentAmount);
                bookModel.setState(State);
                bookModel.setAmount(Amount);
                rentRepository.saveRent(rentModel);
            }
        }
    }
    // 대여 기능

    public void returnBook() {

        List<BookModel> returnbookmodel = bookRepository.findbook();
        List<RentModel> returnrentModel = rentRepository.findrent();
        UserModel currentUserModel = userRepository.currentUser();

        String Amount = "1";
        String State = "Rentable";
        String returnIsbn = null;

        Scanner scanner = new Scanner(System.in);

        PageView.returnpage2();
        System.out.print("\t\t\tEnter the ISBN of the book you want to return : ");
        returnIsbn = scanner.nextLine();
        for (BookModel bookmodel : returnbookmodel) {
            if (bookmodel.getIsbn().contains(returnIsbn)) {
                bookmodel.setAmount(Amount);
                bookmodel.setState(State);
            }
        }
        for (int i = 0; i < returnrentModel.size(); i++) {
            if (returnrentModel.get(i).getIsbn().contains(returnIsbn)
                    && returnrentModel.get(i).getId().equals(currentUserModel.getId())) {
                returnrentModel.remove(i);
            }
        }
    }               // 반납 기능



    public boolean multiReturn() {

        List<BookModel> returnbookmodel = bookRepository.findbook();
        List<RentModel> returnrentModel = rentRepository.findrent();
        UserModel currentUserModel = userRepository.currentUser();

        int count = 0;
        String State = "On loan";
        for (BookModel bookmodel : returnbookmodel) {
            for (RentModel rentmodel : returnrentModel) {
                if (bookmodel.getState().equals(State) && rentmodel.getId().equals(currentUserModel.getId())) {
                    count++;
                }
            }
        }
        if (count > 1) {
            return true;
        } else {
            return false;
        }
    }


}
