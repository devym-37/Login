package model;

public class RentModel {

    private String Id;
    private String Writer;
    private String BookName;
    private String Amount;
    private String Isbn;

    public RentModel() {}

    public RentModel(String id, String writer, String bookName, String amount, String isbn) {
        Id = id;
        Writer = writer;
        BookName = bookName;
        Amount = amount;
        Isbn = isbn;
    }

    public String getId() { return Id; }

    public void setId(String id) { Id = id; }

    public String getWriter() { return Writer; }

    public void setWriter(String writer) { Writer = writer; }

    public String getBookName() { return BookName; }

    public void setBookName(String bookName) { BookName = bookName; }

    public String getAmount() { return Amount; }

    public void setAmount(String amount) { Amount = amount; }

    public String getIsbn() { return Isbn; }

    public void setIsbn(String isbn) { Isbn = isbn; }

    @Override
    public String toString() {
        return "RentModel{" +
                "Id='" + Id + '\'' +
                ", Writer='" + Writer + '\'' +
                ", BookName='" + BookName + '\'' +
                ", Amount='" + Amount + '\'' +
                ", Isbn='" + Isbn + '\'' +
                '}';
    }
}
