package repository;

import DB.LocalDB;
import model.RentModel;

import java.util.List;

public class RentRepository {

    public int saveRent(RentModel rentModel) {
        LocalDB.rentlist.add(rentModel);
        return 0;
    }

    public List<RentModel> findrent() { return LocalDB.rentlist; }

}
