package com.sotosmen.demo.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sotosmen.demo.user.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
public class Post {
    @Id
    @GeneratedValue
    private int post_id;

    private Date creationDate;
    @Size(min = 50)
    private String details;
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post(int post_id, Date creationDate, String details) {
        this.post_id = post_id;
        this.creationDate = creationDate;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", creationDate=" + creationDate +
                ", details='" + details + '\'' +
                '}';
    }
}
