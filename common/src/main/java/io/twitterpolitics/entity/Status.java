package io.twitterpolitics.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @Column(name = "status_id")
    private long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "status_text")
    private String text;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
