package project;

import DB.LocalDB;
import model.BookModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.BookRepository;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService = new BookService();


    @Before
    public void setup() {
        LocalDB.init();
    }

    @Test
    public void saveBook_return0(){
        // given
        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";
        String amount = "1";
        String state = "Rentable";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);
        bookModel.setAmount(amount);
        bookModel.setState(state);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.saveBook(writer, bookName, isbn, amount, state);

        //  then
        assertThat(result, is(0));

    }

    @Test
    public void saveBook_return1(){
        // given
        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";

        String testWriter = "temp";
        String testBookName = "tempName";
        String testIsbn = "tempIsbn";
        String testAmount = "tempAmount";
        String testState = "tempState";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.saveBook(testWriter, testBookName, testIsbn, testAmount, testState);

        //  then
        assertThat(result, is(1));
    }

    @Test
    public void enrollBook_return0(){
        //  given
        String value = "invalid";

        //  when
        int result = bookService.enrollBook(value);

        //  then
        assertThat(result, is(0));
    }

    @Test
    public void enrollBook_return1(){
        //  given
        String value = "Y";

        //  when
        int result = bookService.enrollBook(value);

        //  then
        assertThat(result, is(1));
    }

    @Test
    public void enrollBook_return2(){
        //  given
        String value = "N";

        //  when
        int result = bookService.enrollBook(value);

        //  then
        assertThat(result, is(2));
    }

    @Test
    public void searchWriter_return0(){
        //  given
        String testWriter = "null";

        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.search_writer(testWriter);

        //  then
        assertThat(result, is(0));

    }

    @Test
    public void searchWriter_return1(){
        //  given
        String testWriter = "최승필";

        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";
        String amount = "1";
        String state = "Rentable";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);
        bookModel.setAmount(amount);
        bookModel.setState(state);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.search_writer(testWriter);

        //  then
        assertThat(result, is(1));
    }

    @Test
    public void searchWriter_return2(){
        //  given
        String testWriter = "최승필";

        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";
        String amount = "1";
        String state = "On loan";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);
        bookModel.setAmount(amount);
        bookModel.setState(state);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.search_writer(testWriter);

        //  then
        assertThat(result, is(2));
    }

    @Test
    public void seartchBookname_return0(){
        //  given
        String testBookname = "null";

        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.search_bookname(testBookname);

        //  then
        assertThat(result, is(0));

    }

    @Test
    public void seartchBookname_return1(){
        //  given
        String testBookname = "공부머리 독서법";

        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";
        String amount = "1";
        String state = "Rentable";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);
        bookModel.setAmount(amount);
        bookModel.setState(state);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.search_bookname(testBookname);

        //  then
        assertThat(result, is(1));
    }

    @Test
    public void seartchBookname_return2(){
        String testBookname = "공부머리 독서법";

        String writer = "최승필";
        String bookName = "공부머리 독서법";
        String isbn = "9791196316808";
        String amount = "1";
        String state = "On loan";

        BookModel bookModel = new BookModel();
        bookModel.setWriter(writer);
        bookModel.setBookName(bookName);
        bookModel.setIsbn(isbn);
        bookModel.setAmount(amount);
        bookModel.setState(state);

        List<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(bookModel);

        given(bookRepository.findbook()).willReturn(bookModelList);

        //  when
        int result = bookService.search_bookname(testBookname);

        //  then
        assertThat(result, is(2));
    }

}
