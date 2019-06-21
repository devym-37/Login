package DB;

import model.BookModel;
import model.RentModel;
import model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class LocalDB {

    public static List<UserModel> userlist = new ArrayList<UserModel>();

    public static List<BookModel> booklist = new ArrayList<BookModel>();

    public static List<RentModel> rentlist = new ArrayList<RentModel>();

    public static void init() {
        String[] Name = {"thor", "spiderman", "ironman", "hulk", "thanos", "admin"};
        String[] Email = {"thor@naver.com", "spiderman@naver.com", "ironman@naver.com", "hulk@naver.com", "thanos@naver.com", "admin@naver.com"};
        String[] Id = {"thor", "spiderman", "ironman", "hulk", "thanos", "admin"};
        String[] Password = {"thor123", "spiderman123", "ironman123", "hulk123", "thanos123", "admin123"};

        for (int i = 0; i < 6; i++) {
            UserModel user = new UserModel();
            user.setName(Name[i]);
            user.setEmail(Email[i]);
            user.setId(Id[i]);
            user.setPassword(Password[i]);
            LocalDB.userlist.add(user);
        }
        String[] Writer = {"최승필", "나태주", "Oprah Winfrey", "야마구치 슈", "James Clear"};
        String[] BookName = {"공부머리 독서법", "가장 예쁜 생각을 너에게 주고 싶다", "내가 확실히 아는 것들", "철학은 어떻게 삶의 무기가 되는가", "ATOMIC HABITS"};
        String[] Isbn = {"9791196316808", "9788925561820", "9788956058054", "9791130620459", "9791162540640"};
        String[] Amount = {"1", "0", "1", "0", "1"};
        String[] State = {"Rentable", "On loan", "Rentable", "On loan", "Rentable"};

        for (int i = 0; i < 5; i++) {
            BookModel book = new BookModel();
            book.setWriter(Writer[i]);
            book.setBookName(BookName[i]);
            book.setIsbn(Isbn[i]);
            book.setAmount(Amount[i]);
            book.setState(State[i]);
            LocalDB.booklist.add(book);
        }

        // already rent user
        RentModel currRent = new RentModel();
        currRent.setId(Id[0]);
        currRent.setWriter(Writer[1]);
        currRent.setBookName(BookName[1]);
        currRent.setAmount(Amount[1]);
        currRent.setIsbn(Isbn[1]);
        LocalDB.rentlist.add(currRent);

        RentModel currRent1 = new RentModel();
        currRent1.setId(Id[1]);
        currRent1.setWriter(Writer[3]);
        currRent1.setBookName(BookName[3]);
        currRent1.setAmount(Amount[3]);
        currRent1.setIsbn(Isbn[3]);
        LocalDB.rentlist.add(currRent1);
    }
}
