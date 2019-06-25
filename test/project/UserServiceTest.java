package project;

import DB.LocalDB;
import model.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.UserRepository;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService = new UserService();

    @Before
    public void setup() {
        LocalDB.init();
    }

    @Test
    public void saveUser_return0() {
        //  given
        String id = "temp";
        String password = "tempPassword";
        String email = "temp@temp.com";
        String name = "temp";

        //  when
        int result = userService.saveUser(id, password, name, email);

        //  then
        assertThat(result, is(0));
    }

    @Test
    public void saveUser_return1() {
        //  given
        String id = "thor";
        String password = "thorPassword";
        String name = "thor";
        String email = "thor@naver.com";

        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword(password);
        userModel.setName(name);
        userModel.setEmail(email);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        //  when
        int result = userService.saveUser(id, password, name, email);

        // then
        assertThat(result, is(1));
    }

    @Test
    public void saveUser_return2(){
        //  given
        String id = "thor";
        String password = "thorPassword";
        String name = "thor";
        String email = "thor@naver.com";

        String testId = "temp";
        String testPwd = "thorPassword";
        String testName = "thor";
        String testEmail = "thor@naver.com";

        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword(password);
        userModel.setName(name);
        userModel.setEmail(email);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        // when
        int result = userService.saveUser(testId, testPwd, testName, testEmail);

        // then
        assertThat(result, is(2));
    }

    @Test
    public void saveUser_return3(){
        // given
        String id = "thor";
        String password = "thorPassword";
        String name = "thor";
        String email = "thor@naver.com";

        String testId = "temp";
        String testPwd = "tempPassword";
        String testName = "thor";
        String testEmail = "thor@naver.com";

        UserModel userModel1 = new UserModel();
        userModel1.setId(id);
        userModel1.setPassword(password);
        userModel1.setName(name);
        userModel1.setEmail(email);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel1);

        given(userRepository.findUser()).willReturn(userModelList);

        // when
        int result = userService.saveUser(testId, testPwd, testName, testEmail);

        // then
        assertThat(result, is(3));
    }

    @Test
    public void loginTest_return0(){
        // given
        String id = "temp";
        String password = "tempPassword";

        // when
        int result = userService.login(id, password);

        // then
        assertThat(result, is(0));
    }

    @Test
    public void loginTset_return1(){
        // given
        String id = "thor";
        String password = "tempPassword";

        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword("invalid");

        List<UserModel> userModelList = new ArrayList();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        // when
        int result = userService.login(id, password);

        // then
        assertThat(result, is(1));
    }

    @Test
    public void loginTest_return2(){
        // given
        String id = "thor";
        String passowrd = "thor123";

        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword(passowrd);

        List<UserModel> userModelList = new ArrayList();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        // when
        int result = userService.login(id, passowrd);

        // then
        assertThat(result, is(2));
    }

    @Test
    public void loginTest_return3(){
        // given
        String id = "admin";
        String passowrd = "admin123";

        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword(passowrd);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        // when
        int result = userService.login(id, passowrd);

        // then
        assertThat(result, is(3));
    }

    @Test
    public void logoutUser_return0(){
        // given
        String value = "temp";

        // when
        int result = userService.logoutUser(value);

        // then
        assertThat(result, is(0));
    }

    @Test
    public void logoutUser_return1(){
        // given
        String value = "Y";
//        doNothing().when(userRepository).setLogout();

        // when
        int result = userService.logoutUser(value);

        // then
        assertThat(result, is(1));
    }

    @Test
    public void logoutUser_return2(){
        // given
        String value = "N";

        // when
        int result = userService.logoutUser(value);

        // then
        assertThat(result, is(2));
    }

    @Test
    public void findUser_return0(){
        // given
        String name = "thor";
        String email = "thor@naver.com";

        String testName = "temp";
        String testEmail = "temp@naver.com";

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        // when
        int result = userService.findUser(testName, testEmail);

        // then
        assertThat(result, is(0));

    }

    @Test
    public void findUser_return1(){
        // given
        String name = "thor";
        String email = "thor@naver.com";
        String id = "thor";
        String password = "thor123";

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setId(id);
        userModel.setPassword(password);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        //  when
        int result = userService.findUser(name, email);

        //  then
        assertThat(result, is(1));
    }

    @Test
    public void removeUser_return0(){
        //  given
        String id = "thor";
        String name = "thor";
        String password = "thor123";

        String testId = "temp";
        String testName = "temp";
        String testPwd = "tempPassword";

        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setName(name);
        userModel.setPassword(password);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        //  when
        int result = userService.removeUser(testName, testId, testPwd);

        //  then
        assertThat(result, is(0));
    }

    @Test
    public void removeUser_return1(){
        //  given
        String id = "thor";
        String name = "thor";
        String password = "thor123";


        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setName(name);
        userModel.setPassword(password);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel);

        given(userRepository.findUser()).willReturn(userModelList);

        //  when
        int result = userService.removeUser(name, id, password);

        //  then
        assertThat(result, is(1));

    }

}
