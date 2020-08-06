package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;


    //default constructor
    public Post() {
    }

    public Post(long id, String title, String body, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @ManyToOne
//    @JoinColumn (name = "author_id")
//    private User author;
//
//    public User getAuthor() {
////        return author;
////    }
//
////        public User setAuthor (String author){
////        this.author = author;
////    }
//


    }

}