package oracle.springboot.apps.userservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
// @NoArgsConstructor
// @AllArgsConstructor
// @Data
// @Builder
public class User {
    @Column(name = "user_name")
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
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
