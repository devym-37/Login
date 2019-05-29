package view;

import model.RentModel;
import repository.UserRepository;

import java.util.List;

public class RentView {

    public void rent_View(){
        UserRepository rentRepository = new UserRepository();
        List<RentModel> renta = rentRepository.findrent();
        RentModel rent3 = new RentModel();
        for (RentModel rent3 : renta) {
            System.out.println(rent3.getId());
        }


    }

}
