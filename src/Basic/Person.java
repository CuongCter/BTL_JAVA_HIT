package Basic;

public class Person {
    private int idPerson;
    private String userName;
    private String passWord;
    private String email;
    private String namePerson;
    private String phoneNumber;
    private String permission;

    public Person() {
    }

    public Person(int idPerson, String userName, String passWord, String email, String namePerson, String phoneNumber, String permission) {
        this.idPerson = idPerson;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.namePerson = namePerson;
        this.phoneNumber = phoneNumber;
        this.permission = permission;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", namePerson='" + namePerson + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
