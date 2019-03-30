package model;

public class BookModel {

    private String Writer;
    private String BookName;
    private String Isbn;
    private String Amount;
    private String State;

    public BookModel() {}

    public BookModel(String BookName, String Writer, String Isbn, String Amount, String State){
        this.BookName = BookName;
        this.Writer = Writer;
        this.Isbn = Isbn;
        this.Amount = Amount;
        this.State = State;
    }

    public String getWriter() { return Writer; }

    public void setWriter(String writer) { Writer = writer; }

    public String getBookName() { return BookName; }

    public void setBookName(String bookName) { BookName = bookName; }

    public String getIsbn() { return Isbn; }

    public void setIsbn(String Isbn) { this.Isbn = Isbn; }

    public String getAmount() { return Amount; }

    public void setAmount(String amount) { Amount = amount; }

    public String getState() { return State; }

    public void setState(String state) { State = state; }

    @Override
    public String toString() {
        return "BookModel{" +
                "Writer='" + Writer + '\'' +
                ", BookName='" + BookName + '\'' +
                ", Isbn='" + Isbn + '\'' +
                ", Amount='" + Amount + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
