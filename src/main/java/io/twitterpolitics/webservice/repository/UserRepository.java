package io.twitterpolitics.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import io.twitterpolitics.webservice.entity.User;

@RestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String> {

}
