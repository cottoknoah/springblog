package com.codeup.springblog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = true)
    private String password;

//    default constructor
    public User(){}

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email =  email;
        this.password = password;
    }
//what if there's no id? - method overload
    public User(String username, String email, String password) {
        this.username = username;
        this.email =  email;
        this.password = password;
    }
//from the security lesson
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

//    allows me to propagate changes - multiple cascades being done
//    if i delete a user then all posts are deleted also
//    mapped by is he name of the FK property???
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Post> posts;

}
