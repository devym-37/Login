package service;

import model.UserModel;
import repository.UserRepository;

// 지능부분 담당, 데이터 처리 담당


public class UserService {
    UserRepository userRepository = new UserRepository();

    public int saveUser(String id, String password){
        UserModel user = new UserModel(id, password);

        userRepository.saveUser(user);
        return 0;
    }

}
