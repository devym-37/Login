package view;

import model.RentModel;
import repository.UserRepository;

import java.util.List;

public class RentView {

    public void rent_View(){
        UserRepository rentRepository = new UserRepository();
        List<RentModel> rentlist = rentRepository.findrent();


    }

}
