package com.helidonapps.userserviceapp.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Access(AccessType.PROPERTY)
@Entity(name = "Task")
@Table(name = "tasks")
@NamedQueries({
        @NamedQuery(name = "getAllTask", query = "select t from Task t"),
        @NamedQuery(name = "getTaskById", query = "select t from Task t where id = :id")
})
public class Task {

    private int id;

    private String title;
    private boolean completed;
    private User user;
    private int userId;

    public Task() {
    }

    public Task(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", insertable = false, updatable = false, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Column(name = "title", insertable = true, updatable = true, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic(optional = false)
    @Column(name = "completed", insertable = true, updatable = true, nullable = false)
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true, insertable = true, updatable = true)
    // @OneToOne(targetEntity = User.class)
    // @JoinColumn(name = "user_id", nullable = true)
    // @JsonbTransient
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Transient
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", completed=" + completed + ", user="
                + user + "]";
    }

}
