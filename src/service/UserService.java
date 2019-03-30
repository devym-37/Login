package service;


import front.FrontView;
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

    public int saveUser(String id, String password, String name, String email){

        List<UserModel> check_List = userRepository.findAll();      // 1
        for(UserModel model : check_List){                          // 2
            if(id.equals(model.getId())){
                return -1;                                          // 값만 반환하고 기능 정지
            }
        }
        UserModel newUser = new UserModel(id, password, name, email);            // 3
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

    public int findUser(String name, String email){
        int result = 0;         // 0 : 동일한 이름과 email없음 1: id / pwd 반환
        // 1. userList를 가져온다.
        List<UserModel> findUser = userRepository.findAll();
        // 2. userList를 돌며, 이름과 email 확인
        String ID = null;
        String Pwd = null;
        for (UserModel model : findUser) {
            if(name.equals(model.getName()) && email.equals(model.getEmail())){
                result = 1;
                ID = model.getId();
                Pwd = model.getPassword();
                FrontView.existIDPWD();
                System.out.println("Your ID : " + ID);
                System.out.println("Your Password : " + Pwd);
                return result;                  // id / pwd 반환
            }
        }
        // 3. 똑같은 이름과 email이 있으면 id / pwd 반환환
        return result;                      // 입력받은 이름과 email 데이터 없음
   }
}
