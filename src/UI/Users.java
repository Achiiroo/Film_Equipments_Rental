
package UI;

public class Users {
    private String userId;
    private String FullName;
    private String email;
    private String Password;
    private String user_type;
    private String address;
    private int phone_number;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullname(String fullname) {
        this.FullName = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password){
        this.Password = password;
    }
    public String getPassword(){
        return Password;
    }
    public void setUserType(String usertype){
        this.user_type = usertype;
    }
    public String getUserType(){
        return user_type;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setPhoneNumber(int phonenumber){
        this.phone_number = phonenumber;
    }
    public int getPhoneNumber(){
        return phone_number;
    }
    public Users(String userId, String FullName, String email, String password, String userType, String address, int phonenumber){
        this.userId = userId;
        this.FullName = FullName;
        this.email = email;
        this.Password = password;
        this.user_type = userType;
        this.address = address;
        this.phone_number = phonenumber;
    }
}
