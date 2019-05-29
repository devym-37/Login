import DB.LocalDB;
import model.BookModel;
import model.RentModel;
import model.UserModel;
import repository.UserRepository;
import view.BookView;

import java.util.List;


public class EntryPoint {

    public static void main(String[] args) {
        String[] Name = {"thor", "spiderman", "ironman", "hulk", "thanos"};
        String[] Email = {"thor@naver.com", "spiderman@naver.com", "ironman@naver.com", "hulk@naver.com", "thanos@naver.com"};
        String[] Id = {"thor", "spiderman", "ironman", "hulk", "thanos"};
        String[] Password = {"thor123", "spiderman123", "ironman123", "hulk123", "thanos123"};

        for(int i = 0; i < 5; i++){
            UserModel user= new UserModel();
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

        for(int i = 0; i < 5; i++){
            BookModel book = new BookModel();
            book.setWriter(Writer[i]);
            book.setBookName(BookName[i]);
            book.setIsbn(Isbn[i]);
            book.setAmount(Amount[i]);
            book.setState(State[i]);
            LocalDB.booklist.add(book);
        }

        // already rent user
        RentModel rent = new RentModel();
        UserRepository rentRepository = new UserRepository();
        List<UserModel> select_user = rentRepository.findAll();
        List<BookModel> select_Book = rentRepository.findbook();
        rent.setId(Id[0]);
        rent.setId(Id[1]);
        for (BookModel book : select_Book) {
            String stateValue = "On loan";
            if(stateValue.equals(book.getState())){
                rent.setWriter(book.getWriter());
                rent.setBookName(book.getBookName());
                rent.setAmount(book.getAmount());
            }
        }


        BookView bookView = new BookView();

        //ModuleView.execute_program();               // 실행

    }

}
