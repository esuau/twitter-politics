package io.twitterpolitics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trends")
public class Trend {

    /**
     * The identifier of the status.
     */
    @Id
    @Column(name = "trend_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The label of the trend.
     */
    @Column(name = "trend_name")
    private String name;

}
