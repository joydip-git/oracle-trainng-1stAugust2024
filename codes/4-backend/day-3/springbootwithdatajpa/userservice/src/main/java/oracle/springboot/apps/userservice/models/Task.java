package oracle.springboot.apps.userservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;

    private String title;
    private boolean completed;
    // foreign key betwen the tables
    private int userId;

    @OneToOne(mappedBy = "userId")
    private User user;

    public Task() {
    }

    public Task(int id, String title, boolean completed, int userId, User user) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.userId = userId;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", completed=" + completed + ", userId=" + userId + ", user="
                + user + "]";
    }

}
