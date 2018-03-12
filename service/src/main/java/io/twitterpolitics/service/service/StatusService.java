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

    /**
     * Gets the tweets of the day posted between 7AM and 9AM CET.
     *
     * @return the tweets
     */
    List<Status> getMorningTweets();

}
