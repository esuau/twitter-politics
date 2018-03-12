package io.twitterpolitics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The user.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    /**
     * The identifier of the user.
     */
    @Id
    @Column(name = "user_id")
    private long id;

    /**
     * The name of the user.
     */
    @Column(name = "user_name")
    private String name;

    /**
     * The @ name of the user.
     */
    @Column(name = "screen_name")
    private String screenName;

    /**
     * The URL of the user's profile image.
     */
    @Column(name = "profile_image_url")
    private String profileImageUrl;

}
