package front;

public class PageView {

    public static void Bookpage1(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\t 0. Book List           \t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\t 1. Rentable BookList \t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\t 2. On loan BookList  \t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\t 3. Search a Book     \t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\t 4. Rent a Book         \t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t\t 5. Return Book         \t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public static void searchpage(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t1. Search by author   \t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t\t2. Search by bookname \t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public static void nowriterbook(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t No books have been entered by the author.  \t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public static void nobookname(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t    There are no books titled \t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public static void rentpage1(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t1. Return Page\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t2. Program Off  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public static void rentpage2(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t1. Rent a Book  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t2. Return Page\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }


    public static void rentpage3(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t1. Rent a Book  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t2. Return Booklist Page  \t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public static void rentpage4(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t Currently searched books are being rented. \t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    public static void inputError(){
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│\t\t\t\t\t\t\t\t\t\t\t\t   Input Error  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

}
