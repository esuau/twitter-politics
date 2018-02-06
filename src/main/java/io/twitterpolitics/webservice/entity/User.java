package io.twitterpolitics.webservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", name='" + name + '\''
                + ", email='" + email + '\'' + '}';
    }
}
