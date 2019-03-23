package service;


import model.UserModel;
import repository.UserRepository;

import java.util.List;


// 지능부분 담당, 데이터 처리 담당
// 1. userlist가져오기
// 2. userlist 돌면서 id중복 확인
// 3. 중복된게 없으면 회원가입
// 4. 결과값 반환

public class UserService {
    UserRepository userRepository = new UserRepository();

    public int saveUser(String id, String password){

        List<UserModel> check_List = userRepository.findAll();      // 1
        for(UserModel model : check_List){                          // 2
            if(id.equals(model.getId())){
                return -1;                                          // 값만 반환하고 기능 정지
            }
        }
        UserModel newUser = new UserModel(id, password);            // 3
        userRepository.saveUser(newUser);

        return 1;                                                   // 4
    }

    public int login(String id, String password){
        int result = 0;         // 0 : id없음 , 1 : 비밀번호 틀림 , 2: 로그인 성공
        // 1. userList를 가져온다.
        List<UserModel> check_list = userRepository.findAll();
        // 2. userList를 돌며, id확인
        for (UserModel model : check_list) {
            if(id.equals(model.getId())){
                if(password.equals(model.getPassword())){
                    result = 2;
                    return result;
                }
                result = 1;
                return result;          // 3. 똑같은 id가 있으면, pwd 확인 pwd 틀림
            }

        }
        return result;// 4. 결과값 반환
    }
}
