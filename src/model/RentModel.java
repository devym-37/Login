package model;

public class RentModel {

    private String id;
    private String Writer;
    private String BookName;
    private String Amount;

    public RentModel() {}

    public RentModel(String id, String Writer, String BookName, String Amount){
        this.id = id;
        this.Writer = Writer;
        this.BookName = BookName;
        this.Amount = Amount;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getWriter() { return Writer; }

    public void setWriter(String writer) { Writer = writer; }

    public String getBookName() { return BookName; }

    public void setBookName(String bookName) { BookName = bookName; }

    public String getAmount() { return Amount; }

    public void setAmount(String amount) { Amount = amount; }

    @Override
    public String toString() {
        return "RentModel{" +
                "id='" + id + '\'' +
                ", Writer='" + Writer + '\'' +
                ", BookName='" + BookName + '\'' +
                ", Amount='" + Amount + '\'' +
                '}';
    }
}
