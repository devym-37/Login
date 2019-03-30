package service;

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



}
