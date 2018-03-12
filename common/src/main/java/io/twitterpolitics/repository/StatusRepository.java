package io.twitterpolitics.repository;

import io.twitterpolitics.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RestResource(exported = false)
public interface StatusRepository extends JpaRepository<Status, Long> {

    /**
     * Get the stored tweets created during breakfast time.
     *
     * @param breakfastStart the start date of the breakfast.
     * @param breakfastEnd the end date of the breakfast.
     * @return the list of corresponding tweets.
     */
    @Query("SELECT s FROM Status s WHERE s.createdAt BETWEEN :breakfastStart AND :breakfastEnd")
    List<Status> getBreakfastTweets(@Param("breakfastStart") Date breakfastStart, @Param("breakfastEnd") Date breakfastEnd);

}
