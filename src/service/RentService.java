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
        int listsize = returnrentModel.size();

        if (Value.equalsIgnoreCase(value.toLowerCase())) {
            for (BookModel bookModel : returnbookmodel) {
                for (RentModel rentModel : returnrentModel) {
                    if (!bookModel.getAmount().equals(State) && rentModel.getId().equals(currentUserModel.getId())) {
                        if(multiReturn()) {
                            bookModel.setAmount(Amount);
                            bookModel.setState(State);
                            return 2;
                        }else{
                            bookModel.setAmount(Amount);
                            bookModel.setState(State);

                            return 1;
                        }
                    }
                }
            }
        } else if (nonValue.equalsIgnoreCase(value.toLowerCase())) {
            return 3;
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
                if(bookmodel.getState().equals(State) && rentmodel.getId().equals(currentUserModel.getId())){
                    count++;
                }
            }
        }
        if(count > 1){
            return true;
        }else {
            return false;
        }
    }


}
