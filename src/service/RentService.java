package service;

import model.BookModel;
import model.RentModel;
import model.UserModel;
import repository.UserRepository;

import java.util.List;

public class RentService {
    UserRepository rentRepository = new UserRepository();

    public int saveRent(String Id, String Writer, String BookName, String Amount){
        List<RentModel> check_rent = rentRepository.findrent();
        RentModel newRent = new RentModel(Id, Writer, BookName, Amount);
        rentRepository.saveRent(newRent);
        return 1;
    }




    public int rentBook(String value){
        List<BookModel> bookState = rentRepository.findbook();
        List<UserModel> rentUser = rentRepository.findUser();
        UserRepository currUser = new UserRepository();
        UserModel currUser1 = new UserModel();
        RentModel rentUser1 = new RentModel();
        BookService bookService = new BookService();


        String Value = "Y";
        String nonValue = "N";


        String Writer = null;
        String BookName = null;
        String Amount = "0";
        String State = "On loan";

        if(Value.equalsIgnoreCase(value.toLowerCase())){
            for (BookModel booklist : bookState) {
                    rentUser1.setId(currUser1.getId());
                    rentUser1.setWriter(booklist.getWriter());
                    rentUser1.setBookName(booklist.getBookName());
                    rentUser1.setAmount(State);
                    booklist.setState(State);
                    booklist.setAmount(Amount);
            }
            return 1;
        }else if(nonValue.equalsIgnoreCase(value.toLowerCase())){
            return 2;
        }
        return 0;
    }

    public void returnBook(){

    }

    // 대여 / 반납 기능


}
