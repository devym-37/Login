package service;

import front.PageView;
import model.BookModel;
import repository.UserRepository;

import java.util.List;

public class BookService {
    UserRepository BookRepository = new UserRepository();
    public int saveBook(String Writer, String BookName, String Isbn, String Amount, String State){
        List<BookModel> Booklist = BookRepository.findbook();
        for (BookModel Book : Booklist) {
            if(BookName.equals(Book.getBookName())){
                return -1;
            }
        }
        BookModel newBook = new BookModel(Writer, BookName, Isbn, Amount, State);
        BookRepository.saveBook(newBook);

        return 1;
    }

    public int search_writer(String writer){          // 책 검색
        List<BookModel> check_book = BookRepository.findbook();
        int result = 0;                 // 0 : 책 없음, 1 : 책 있음, 2 : 책 대여중

        String Writer = null;
        String Bookname = null;
        String state = "On loan";
        for (BookModel booklist : check_book) {
            if(writer.equals(booklist.getWriter())){
                if(state.equals(booklist.getState())){
                    PageView.rentpage4();
                    result = 2;
                    return result;
                }
                Writer = booklist.getWriter();
                Bookname = booklist.getBookName();
                System.out.println("┌─────────────────────────────────────────────────────────────┐");
                System.out.println("│\t\t\t\t\t\t\t\t\t\t\tIt's a book in our library\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
                System.out.println("└─────────────────────────────────────────────────────────────┘");
                System.out.print("\t\t\t\t\t\t\t\t\t\tWriter : " + Writer);
                System.out.println("\t\t\tBook Name : " + Bookname);

                result = 1;
                return result;
            }
        }
        return result;
    }

    public int search_bookname(String bookname){          // 책 검색
        List<BookModel> check_book = BookRepository.findbook();
        int result = 0;                 // 0 : 책 없음, 1 : 책 있음, 2 : 책 대여중
        String Writer = null;
        String Bookname = null;
        String state = "On loan";
        for (BookModel booklist : check_book) {
            if(bookname.equals(booklist.getBookName())){
                if(state.equals(booklist.getState())){
                    PageView.rentpage4();
                    result = 2;
                    return result;
                }
                Writer = booklist.getWriter();
                Bookname = booklist.getBookName();

                System.out.println("┌─────────────────────────────────────────────────────────────┐");
                System.out.println("│\t\t\t\t\t\t\t\t\t\t\tIt's a book in our library\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
                System.out.println("└─────────────────────────────────────────────────────────────┘");
                System.out.print("\t\t\t\t\t\t\t\t\t\tWriter : " + Writer);
                System.out.println("\t\t\tBook Name : " + Bookname);

                result = 1;
                return result;
            }
        }
        return result;
    }

    public void rentalBook(){

    }
    // 대여 / 반납 기능



}
