package repository;

import DB.LocalDB;
import model.UserModel;

// User 신상정보 DB에 접근하는 class
// 무조건 DB 접근 메서드만 사용 , 데이터 처리는 service에서 담당

public class UserRepository {

    public int saveUser(UserModel userModel){
        LocalDB.userlist.add(userModel);
        return 0;
    }

}
