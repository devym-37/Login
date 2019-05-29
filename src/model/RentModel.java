package model;

public class RentModel {

    private String Id;
    private String Writer;
    private String BookName;
    private String Amount;

    public RentModel() {}

    public RentModel(String Id, String Writer, String BookName, String Amount){
        this.Id = Id;
        this.Writer = Writer;
        this.BookName = BookName;
        this.Amount = Amount;
    }

    public String getId() { return Id; }

    public void setId(String Id) { this.Id = Id; }

    public String getWriter() { return Writer; }

    public void setWriter(String writer) { Writer = writer; }

    public String getBookName() { return BookName; }

    public void setBookName(String bookName) { BookName = bookName; }

    public String getAmount() { return Amount; }

    public void setAmount(String amount) { Amount = amount; }

    @Override
    public String toString() {
        return "RentModel{" +
                "Id='" + Id + '\'' +
                ", Writer='" + Writer + '\'' +
                ", BookName='" + BookName + '\'' +
                ", Amount='" + Amount + '\'' +
                '}';
    }
}
