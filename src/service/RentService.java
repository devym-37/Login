package service;

import model.RentModel;
import repository.UserRepository;

import java.util.List;

public class RentService {
    UserRepository rentRepository = new UserRepository();

    public int saveRent(String Id, String Writer, String BookName, String Amount){
        List<RentModel> check_rent = rentRepository.findrent();
        RentModel newRent = new RentModel(Id, Writer, BookName, Amount);
        rentRepository.saveRent(newRent);
        return 1;
    }


    public void rentBook(){

    }

    public void returnBook(){

    }

    // 대여 / 반납 기능


}
