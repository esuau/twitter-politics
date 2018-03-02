package io.twitterpolitics.scraper.service;

import twitter4j.TwitterException;

public interface ScraperService {

    void getTrends() throws TwitterException;

    void saveStatuses() throws TwitterException;

}
