package project;

import DB.LocalDB;
import model.RentModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.BookRepository;
import repository.RentRepository;
import service.RentService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RentServiceTest {

    @Mock
    RentRepository rentRepository;
    BookRepository bookRepository;

    @InjectMocks
    RentService rentService = new RentService();

    @Before
    public void setUp(){
        LocalDB.init();
    }

    @Test
    public void saveRent_return1(){
        //  given
        String id = "temp";
        String writer = "tempWriter";
        String bookName = "tempBookname";
        String amount = "1";
        String isbn = "999999999";

        RentModel rentModel = new RentModel();
        rentModel.setId(id);
        rentModel.setWriter(writer);
        rentModel.setBookName(bookName);
        rentModel.setAmount(amount);
        rentModel.setIsbn(isbn);

        List<RentModel> rentModelList = new ArrayList<>();
        rentModelList.add(rentModel);

        given(rentRepository.findrent()).willReturn(rentModelList);

        //  when
        int result = rentService.saveRent(id, writer, bookName, amount, isbn);

        //  then
        assertThat(result, is(1));
    }

    @Test
    public void rentValue_return0(){
        //  given
        String value = "temp";

        //  when
        int result = rentService.rentValue(value);

        //  then
        assertThat(result, is(0));
    }

    @Test
    public void rentValue_return1(){
        //  given
        String value = "Y";

        //  when
        int result = rentService.rentValue(value);

        //  then
        assertThat(result, is(1));
    }

    @Test
    public void rentValue_return2(){
        //  given
        String value = "N";

        //  when
        int result = rentService.rentValue(value);

        //  then
        assertThat(result, is(2));
    }

    @Test
    public void rentBookTest(){

    }

    @Test
    public void returnBookTest(){

    }

}
