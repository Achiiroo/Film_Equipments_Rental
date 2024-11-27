package UI;

public class UserSession {
    private static Users currentUser;

    public static void setCurrentUser(Users user) {
        currentUser = user;
    }
    
    public static String getCurrentUserID() {
        return currentUser != null ? currentUser.getUserId() : null;
    }
}
