package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.time.LocalDateTime;
//import java.util.Date;

@Entity
@Table(name = "user_favorites")
public class UserFavorite {
    private int id;
    private User user;
    private Favorite favorite;
    private LocalDateTime added_on;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "favorite_id")
    public Favorite getFavorite() {
        return favorite;
    }
    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    @Column(name = "added_on")
    //@Temporal(TemporalType.DATE)

    public LocalDateTime getAdded_on() {
        return added_on;
    }
    public void setAdded_on(LocalDateTime localDateTime) {
        this.added_on = localDateTime;
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", user=" + user +
                ", favorite=" + favorite +
                ", added_on=" + added_on ;
    }


}