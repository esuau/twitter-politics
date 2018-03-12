package io.twitterpolitics.scraper.service;

import twitter4j.TwitterException;

/**
 * The service managing the tweet registration.
 */
public interface ScraperService {

    /**
     * Gets the current Twitter trends in France.
     * Trends are refreshed every sixty minutes.
     *
     * @throws TwitterException in case of issue with the Twitter API.
     */
    void getTrends() throws TwitterException;

    /**
     * Saves tweets posted on current trends.
     */
    void saveStatuses() throws TwitterException;

}
