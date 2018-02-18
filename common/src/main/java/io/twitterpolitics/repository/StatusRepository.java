package io.twitterpolitics.repository;

import io.twitterpolitics.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface StatusRepository extends JpaRepository<Status, String> {

}
