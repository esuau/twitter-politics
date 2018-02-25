package io.twitterpolitics.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "screen_name")
    private String screenName;

    @Column(name = "user_url")
    private String url;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @OneToMany(mappedBy = "user")
    private List<Status> statuses;

}
