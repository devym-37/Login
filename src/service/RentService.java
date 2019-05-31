package service;

import model.BookModel;
import model.RentModel;
import model.UserModel;
import repository.UserRepository;

import java.util.List;

public class RentService {
    UserRepository rentRepository = new UserRepository();

    public int saveRent(String Id, String Writer, String BookName, String Amount) {
        List<RentModel> check_rent = rentRepository.findrent();
        RentModel newRent = new RentModel(Id, Writer, BookName, Amount);
        rentRepository.saveRent(newRent);
        return 1;
    }


    public int rentBook(String value) {
        List<BookModel> booklist = rentRepository.findbook();
        UserRepository userRepository = new UserRepository();
        UserModel currentUserModel = userRepository.currentUser();

        String Value = "Y";
        String nonValue = "N";


        String Writer = null;
        String BookName = null;
        String Amount = "0";
        String State = "On loan";

        if (Value.equalsIgnoreCase(value.toLowerCase())) {
            for (BookModel bookModel : booklist) {
                if(!bookModel.getState().equals(State)) {
                    RentModel rentUser1 = new RentModel();
                    rentUser1.setId(currentUserModel.getId());
                    rentUser1.setWriter(bookModel.getWriter());
                    rentUser1.setBookName(bookModel.getBookName());
                    rentUser1.setAmount(State);
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

    public void returnBook() {

    }

    // 대여 / 반납 기능


}
