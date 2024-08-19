package dev.kesorupert.user;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "app_user ")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "UserID")
    public Long id;

    @Column(unique = true, nullable = false)
    public String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
