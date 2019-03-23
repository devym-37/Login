package repository;

import DB.LocalDB;
import model.UserModel;
import java.util.List;

// User 신상정보 DB에 접근하는 class
// 무조건 DB 접근 메서드만 사용 , 데이터 처리는 service에서 담당

public class UserRepository {

    public int saveUser(UserModel userModel){
        LocalDB.userlist.add(userModel);
        return 0;
    }
    public List<UserModel> findAll(){           // List<UserModel> 반환해야할 정보 List
        return LocalDB.userlist;
    }

}
