package service;

import DB.LocalDB;
import front.frontView;
import model.UserModel;
import repository.UserRepository;
import view.LoginView;

public class FilterUser extends LoginView {
    UserRepository userRepository = new UserRepository();
    LoginView registerUser = new LoginView();
    UserModel userModel = new UserModel();
    frontView frontView = new frontView();
    LoginView loginView = new LoginView();

    public void getUserRepository() {
        loginView.registerView();
        String filterId = userModel.getId();
        for(int i = 0; i < LocalDB.userlist.size(); i++){
           if(filterId == null){
               frontView.existing_front();
               frontView.frontDesign();
           }else{
               loginView.registerView();
           }
        }
    }
}
