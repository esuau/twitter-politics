package io.twitterpolitics.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Status {

    @Id
    private long id;

    private Date createdAt;

    private String text;

}
