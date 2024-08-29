package oracle.springboot.apps.userservice.models;

public class User {
    private String userName;
    private int userId;

    public User() {
    }

    public User(int userId, String userName) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", userId=" + userId + "]";
    }
}
