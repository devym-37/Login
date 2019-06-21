package service;


import view.FrontView;
import model.UserModel;
import repository.UserRepository;

import java.util.Iterator;
import java.util.List;


// 지능부분 담당, 데이터 처리 담당
// 1. userlist가져오기
// 2. userlist 돌면서 id중복 확인
// 3. 중복된게 없으면 회원가입
// 4. 결과값 반환

public class UserService {

    UserRepository userRepository = new UserRepository();

    public int saveUser(String id, String password, String name, String email) {

        List<UserModel> check_List = userRepository.findUser();      // 1
        // 2
        for (UserModel model : check_List) {
            if (id.equals(model.getId())) {
                return 1;                                          // 값만 반환하고 기능 정지
            } else if (password.equals(model.getPassword())) {
                return 2;
            } else if (email.equals(model.getEmail())) {
                return 3;
            }
        }

        UserModel newUser = new UserModel(id, password, name, email);            // 3
        userRepository.saveUser(newUser);

        return 0;                                                   // 4
    }

    public int login(String id, String password) {
        int result = 0;         // 0 : id없음 , 1 : 비밀번호 틀림 , 2: 로그인 성공
        // 1. userList를 가져온다.
        List<UserModel> check_list = userRepository.findUser();

        String adId = "admin";
        String adPwd = "admin123";

        // 2. userList를 돌며, id확인
        for (UserModel model : check_list) {
            if (id.equals(model.getId())) {
                if (password.equals(model.getPassword())) {
                    UserModel currentUser = new UserModel(id, password, null, null);
                    userRepository.loginUser(currentUser);
                    result = 2;
                    return result;
                }
                result = 1;
                return result;          // 3. 똑같은 id가 있으면, pwd 확인 pwd 틀림
            } else if (id.equals(adId)) {
                if (password.equals(adPwd)) {
                    UserModel currentUser = new UserModel(id, password, null, null);
                    userRepository.loginUser(currentUser);
                    result = 3;
                    return result;          // 4. 관리자 ID 확인
                }
            }
        }
        return result;// 4. 결과값 반환
    }

    public int logoutUser(String value) {
        int result = 0;

        String Value = "Y";
        String nonValue = "N";

        if (Value.equalsIgnoreCase(value.toLowerCase())) {
            userRepository.setLogout();
            return 1;
        } else if (nonValue.equalsIgnoreCase(value.toLowerCase())) {
            return 2;
        }
        return result;
    }


    public int findUser(String name, String email) {
        int result = 0;         // 0 : 동일한 이름과 email없음 1: id / pwd 반환
        // 1. userList를 가져온다.
        List<UserModel> findUser = userRepository.findUser();
        // 2. userList를 돌며, 이름과 email 확인
        String ID = null;
        String Pwd = null;
        for (UserModel model : findUser) {
            if (name.equals(model.getName()) && email.equals(model.getEmail())) {
                result = 1;
                ID = model.getId();
                Pwd = model.getPassword();
                FrontView.existIDPWD();
                System.out.println("\t\t\tYour ID : " + ID);
                System.out.println("\t\t\tYour Password : " + Pwd);
                return result;                  // id / pwd 반환
            }
        }
        // 3. 똑같은 이름과 email이 있으면 id / pwd 반환환
        return result;                      // 입력받은 이름과 email 데이터 없음
    }

    public int removeUser(String name, String id, String password) {
        int result = 0;         // 0 : 입력한 내용의 data가 없음
        List<UserModel> removeUser = userRepository.findUser();
        Iterator<UserModel> itUser = removeUser.iterator();
        String Name = null;
        String Id = null;
        String Pwd = null;
        Name = name;
        Id = id;
        Pwd = password;
        while (itUser.hasNext()) {
            UserModel value = itUser.next();
            if (Name.equals(value.getName()) && Id.equals(value.getId()) && Pwd.equals(value.getPassword())) {
                result = 1;          // 1 : date delete
                itUser.remove();
                return result;
            }
        }
        return result;               // result = 0;
    }


}
