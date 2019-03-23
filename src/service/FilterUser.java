package service;

import DB.LocalDB;
import front.frontView;
import model.UserModel;
import repository.UserRepository;
import view.RegisterView;

public class FilterUser extends RegisterView {
    UserRepository userRepository = new UserRepository();
    RegisterView registerUser = new RegisterView();
    UserModel userModel = new UserModel();
    frontView frontView = new frontView();
    RegisterView loginView = new RegisterView();

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
