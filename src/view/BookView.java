package view;

import front.PageView;
import model.BookModel;
import repository.UserRepository;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookView {
    UserRepository userRepository = new UserRepository();

    public void currentBookView() {
        List<BookModel> booklist = userRepository.findbook();
        String writer = null;
        String bookname = null;
        String isbn = null;
        String amount = null;
        String state = null;
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\tBook List\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\tWriter\t\t\t\t\t\tBook Name\t\t\t\t\t\t\t\t\tISBN\t\t\t\tAmount\t\tState\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        Object list0 = booklist.get(0);
        Object list1 = booklist.get(1);
        Object list2 = booklist.get(2);
        Object list3 = booklist.get(3);
        Object list4 = booklist.get(4);

        System.out.printf("|\t\t  %s\t\t\t\t\t%s\t\t\t\t\t\t\t\t%s\t\t\t  %s\t\t  %s  |%n",
                ((BookModel) list0).getWriter(), ((BookModel) list0).getBookName(), ((BookModel) list0).getIsbn(), ((BookModel) list0).getAmount(), ((BookModel) list0).getState());
        System.out.printf("|\t\t  %s\t\t\t\t\t%s   \t\t%s\t\t\t  %s\t\t  %s\t|%n",
                ((BookModel) list1).getWriter(), ((BookModel) list1).getBookName(), ((BookModel) list1).getIsbn(), ((BookModel) list1).getAmount(), ((BookModel) list1).getState());
        System.out.printf("|\t\t  %s\t\t\t\t%s\t\t\t\t\t\t%s\t\t\t  %s\t\t  %s\t|%n",
                ((BookModel) list2).getWriter(), ((BookModel) list2).getBookName(), ((BookModel) list2).getIsbn(), ((BookModel) list2).getAmount(), ((BookModel) list2).getState());
        System.out.printf("|\t\t  %s\t\t\t\t%s    \t\t%s\t\t\t  %s\t\t  %s\t|%n",
                ((BookModel) list3).getWriter(), ((BookModel) list3).getBookName(), ((BookModel) list3).getIsbn(), ((BookModel) list3).getAmount(), ((BookModel) list3).getState());
        System.out.printf("|\t\t  %s\t\t\t\t%s\t\t\t\t\t\t\t%s\t\t\t  %s\t\t  %s\t|%n",
                ((BookModel) list4).getWriter(), ((BookModel) list4).getBookName(), ((BookModel) list4).getIsbn(), ((BookModel) list4).getAmount(), ((BookModel) list4).getState());

        PageView.rentpage1();
    }

    public void search_Writer() {                    // 책 저자로 검색
        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);
        String Writer = null;

        System.out.print("Search Writer : ");
        Writer = scanner.nextLine();

        int response = bookService.search_writer(Writer);
        switch (response) {
            case 0:             // 검색한 책 없음
                PageView.nowriterbook();
                break;
            case 1:             // 검색한 책 있음
                break;
            case 2:             // 검색한 책 대여중
                break;
        }

    }

    public void search_Bookname() {                    // 책 이름으로 검색
        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);
        String Bookname = null;

        System.out.print("Search Bookname : ");
        Bookname = scanner.nextLine();
        int response = bookService.search_bookname(Bookname);
        switch (response) {
            case 0:             // 검색한 책 없음
                PageView.nobookname();
                break;
            case 1:             // 검색한 책 있음
                break;
            case 2:             // 검색한 책 대여중
                break;
        }
    }

    public void rentbook(){

    }

}
