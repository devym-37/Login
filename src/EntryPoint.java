import DB.LocalDB;
import view.ModuleView;


public class EntryPoint {

    public static void main(String[] args) {

        LocalDB.init();

        /*
        UserRepository rentRepository = new UserRepository();
        List<BookModel> select_Book = rentRepository.findbook();
        List<UserModel> select_User = rentRepository.findUser();
        List<RentModel> check_Rent = rentRepository.findrent();
        for (BookModel book : select_Book) {
            RentModel rent = new RentModel();
            for (UserModel user : select_User) {
                for (RentModel rentModel : check_Rent) {
                    String stateValue = "On loan";
                    if (stateValue.equals(book.getState())) {
                        if (!rentModel.getWriter().equals(book.getWriter())) {
                            rent.setId(user.getId());
                            rent.setWriter(book.getWriter());
                            rent.setBookName(book.getBookName());
                            rent.setAmount(book.getAmount());
                            LocalDB.rentlist.add(rent);
                        }
                    }
                }
            }
        }
        */




        ModuleView.execute_program();               // 실행


    }


}
