package io.twitterpolitics.repository;

import io.twitterpolitics.entity.Trend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface TrendRepository extends JpaRepository<Trend, Long> {

    /**
     * Checks if a trend is already existing.
     *
     * @param name the name we are looking for.
     * @return true if the trend exists, false if not.
     */
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Trend t WHERE t.name = :name")
    boolean checkTrendExists(@Param("name") String name);

}
