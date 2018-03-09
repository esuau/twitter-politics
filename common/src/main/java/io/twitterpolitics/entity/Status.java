package io.twitterpolitics.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * The tweet.
 */
@Data
@Entity
@Table(name = "statuses")
public class Status {

    /**
     * The identifier of the tweet.
     */
    @Id
    @Column(name = "status_id")
    private long id;

    /**
     * The creation date of the tweet.
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * The text content of the tweet.
     */
    @Column(name = "status_text")
    private String text;

    /**
     * The author of the tweet.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

}
