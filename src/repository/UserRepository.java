package repository;

import DB.LocalDB;
import DB.LoginDB;
import model.UserModel;

import java.util.List;

// User 신상정보 DB에 접근하는 class
// 무조건 DB 접근 메서드만 사용 , 데이터 처리는 service에서 담당

public class UserRepository {

    public int saveUser(UserModel userModel) {
        LocalDB.userlist.add(userModel);
        return 0;
    }

    public int loginUser(UserModel userModel){
        LoginDB.loginUser = userModel;
        return 0;
    }

    public UserModel logoutuser(){ return LoginDB.loginUser; }

    public UserModel currentUser(){ return LoginDB.loginUser; }

    public void setLogout(){
        LoginDB.loginUser.setId(null);
        LoginDB.loginUser.setPassword(null);
        LoginDB.loginUser.setEmail(null);
        LoginDB.loginUser.setName(null);
    }

    public List<UserModel> findUser() {           // List<UserModel> 반환해야할 정보 List
        return LocalDB.userlist;
    }

}
