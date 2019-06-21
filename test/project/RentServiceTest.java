package project;

import DB.LocalDB;
import model.UserModel;
import org.junit.Before;
import org.junit.Test;
import repository.UserRepository;
import service.RentService;
import service.UserService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class RentServiceTest {

    RentService rentService = new RentService();
    UserService userService = new UserService();

    @Before
    public void setUp(){
        LocalDB.init();
    }

    @Test
    public void rentBookTest(){
        //  given
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserModel currentUserModel = new UserModel("thor2", "password", "name", "email@company.com");

        given(mockUserRepository.currentUser()).willReturn(currentUserModel);
        //  when
        rentService.rentBook();
        //  then
    }
}
