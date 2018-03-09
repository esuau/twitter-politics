package io.twitterpolitics.service.service;

import io.twitterpolitics.entity.Status;

import java.util.List;

/**
 * The service getting the tweets.
 */
public interface StatusService {

    /**
     * Gets all the stored tweets.
     *
     * @return the list of stored tweets.
     */
    List<Status> findAll();

}
