package service;

import front.PageView;
import model.BookModel;
import model.RentModel;
import model.UserModel;
import repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class RentService {
    UserRepository rentRepository = new UserRepository();

    public int saveRent(String Id, String Writer, String BookName, String Amount, String Isbn) {
        List<RentModel> check_rent = rentRepository.findrent();
        RentModel newRent = new RentModel(Id, Writer, BookName, Amount, Isbn);
        rentRepository.saveRent(newRent);
        return 1;
    }


    public int rentBook(String value) {
        List<BookModel> booklist = rentRepository.findbook();
        UserRepository userRepository = new UserRepository();
        UserModel currentUserModel = userRepository.currentUser();
        BookModel searchBookModel = userRepository.callsearchBookName();

        String Value = "Y";
        String nonValue = "N";
        String Amount = "0";
        String State = "On loan";

        if (Value.equalsIgnoreCase(value.toLowerCase())) {
            for (BookModel bookModel : booklist) {
                if (!bookModel.getState().equals(State) && (searchBookModel.getBookName().equals(bookModel.getBookName())
                        || searchBookModel.getWriter().equals(bookModel.getWriter()))) {
                    RentModel rentUser1 = new RentModel();
                    rentUser1.setId(currentUserModel.getId());
                    rentUser1.setWriter(bookModel.getWriter());
                    rentUser1.setBookName(bookModel.getBookName());
                    rentUser1.setAmount(State);
                    rentUser1.setIsbn(bookModel.getIsbn());
                    bookModel.setState(State);
                    bookModel.setAmount(Amount);
                    rentRepository.saveRent(rentUser1);
                }
            }
            return 1;
        } else if (nonValue.equalsIgnoreCase(value.toLowerCase())) {
            return 2;
        }
        return 0;
    }
    // 대여 기능

    public int returnBook(String value) {                   // 반납 기능
        List<BookModel> returnbookmodel = rentRepository.findbook();
        List<RentModel> returnrentModel = rentRepository.findrent();
        UserRepository userRepository = new UserRepository();
        UserModel currentUserModel = userRepository.currentUser();

        String Value = "Y";
        String nonValue = "N";
        String Amount = "1";
        String State = "Rentable";
        String returnIsbn = null;

        Scanner scanner = new Scanner(System.in);


        if (Value.equalsIgnoreCase(value.toLowerCase())) {
            PageView.returnpage2();
            System.out.print("\t\t\tEnter the ISBN of the book you want to return : ");
            returnIsbn = scanner.nextLine();
            for (BookModel bookmodel : returnbookmodel) {
                if(bookmodel.getIsbn().contains(returnIsbn)){
                    bookmodel.setAmount(Amount);
                    bookmodel.setState(State);
                }
            }
            for (int i = 0; i < returnrentModel.size(); i++) {
                if (returnrentModel.get(i).getIsbn().contains(returnIsbn)
                        && returnrentModel.get(i).getId().equals(currentUserModel.getId())) {
                    returnrentModel.remove(i);
                    return 1;
                }
            }
        }else if (nonValue.equalsIgnoreCase(value.toLowerCase())) {
            return 2;
        }
        return 0;
    }

    public boolean multiReturn() {
        List<BookModel> returnbookmodel = rentRepository.findbook();
        List<RentModel> returnrentModel = rentRepository.findrent();
        UserRepository userRepository = new UserRepository();
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
