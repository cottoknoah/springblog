package com.codeup.springblog.models;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name="ad", schema="spring_db")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(length = 240, nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentAd")
//    private List<Comment> comments;

//example
//    @Column(name = "password", updatable = false, insertable = false)

    public Ad() { }

    public Ad(String title, String description) {
        this.title = title;
        this.description =  description;
    }

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description =  description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}