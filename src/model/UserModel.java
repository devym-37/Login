package model;

public class UserModel {

    private  String id;
    private  String password;

    public  UserModel() { }        // 기본생성자

    public UserModel(String id, String password) {
        this.id = id;
        this.password = password;
    }               // id, pwd 설정한 생성자 : 항상 기본 생성자와 완성한 생성자 두 개 필요

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", password=" + password +
                '}';
    }


}
