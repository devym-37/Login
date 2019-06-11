package repository;

import DB.LocalDB;
import model.BookModel;

import java.util.List;

public class BookRepository {

    public int saveBook(BookModel bookModel) {
        LocalDB.booklist.add(bookModel);
        return 0;
    }

    public List<BookModel> findbook() {
        return LocalDB.booklist;
    }

}