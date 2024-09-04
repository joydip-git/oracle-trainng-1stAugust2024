package com.helidonapps.userserviceapp.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Access(value = AccessType.PROPERTY)
@Entity(name = "User")
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "getAllUser", query = "select u from User u"),
        @NamedQuery(name = "getAnUser", query = "select u from User u where u.userId = :userId")
})
public class User {

    private int userId;
    private String userName;
    private List<Task> tasks;

    public User() {
    }

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Id
    @Column(name = "user_id", nullable = false, updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic(optional = false)
    @Column(name = "user_name", updatable = true, insertable = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonbTransient
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + "]";
    }
}
