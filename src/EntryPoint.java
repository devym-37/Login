import DB.LocalDB;
import model.BookModel;
import model.UserModel;
import view.BookView;
import view.ModuleView;


public class EntryPoint {

    public static void main(String[] args) {

        for(int i = 0; i < 5; i++){
            UserModel user= new UserModel();
            String[] Name = {"thor", "spiderman", "ironman", "hulk", "thanos"};
            String[] Email = {"thor@naver.com", "spiderman@naver.com", "ironman@naver.com", "hulk@naver.com", "thanos@naver.com"};
            String[] Id = {"thor", "spiderman", "ironman", "hulk", "thanos"};
            String[] Password = {"thor123", "spiderman123", "ironman123", "hulk123", "thanos123"};
            user.setName(Name[i]);
            user.setEmail(Email[i]);
            user.setId(Id[i]);
            user.setPassword(Password[i]);
            LocalDB.userlist.add(user);
        }

        for(int i = 0; i < 5; i++){
            BookModel book = new BookModel();
            String[] Writer = {"최승필", "나태주", "Oprah Winfrey", "야마구치 슈", "James Clear"};
            String[] BookName = {"공부머리 독서법", "가장 예쁜 생각을 너에게 주고 싶다", "내가 확실히 아는 것들", "철학은 어떻게 삶의 무기가 되는가", "ATOMIC HABITS"};
            String[] Isbn = {"9791196316808", "9788925561820", "9788956058054", "9791130620459", "9791162540640"};
            String[] Amount = {"1", "1", "1", "1", "1"};
            String[] State = {"Rentable", "On loan", "Rentable", "On loan", "Rentable"};
            book.setWriter(Writer[i]);
            book.setBookName(BookName[i]);
            book.setIsbn(Isbn[i]);
            book.setAmount(Amount[i]);
            book.setState(State[i]);
            LocalDB.booklist.add(book);
        }




        BookView bookView = new BookView();
        // bookView.currentBookView();
        // bookView.rentalList();

        ModuleView.execute_program();               // 실행

    }

}
