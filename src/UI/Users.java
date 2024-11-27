
package UI;

public class Users {
    private String userId;
    private String emailOrUsername;
    private String Password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailOrUsername() {
        return emailOrUsername;
    }

    public void setEmailOrUsername(String email) {
        this.emailOrUsername = email;
    }
    public void setPassword(String password){
        this.Password = password;
    }
    public String getPassword(){
        return Password;
    }
    
    public Users(String userId, String emailOrUsername, String password){
        this.userId = userId;
        this.emailOrUsername = emailOrUsername;
        this.Password = password;
    }
}
