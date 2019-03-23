package model;

public class FilterModel {
    private String id;

    public FilterModel(){ }

    public FilterModel(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
