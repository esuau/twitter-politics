package io.twitterpolitics.service.service;

import io.twitterpolitics.entity.Trend;

import java.util.List;

/**
 * The service getting the trends.
 */
public interface TrendService {

    /**
     * Gets the ten last stored trends.
     *
     * @return the 10 last stored trends.
     */
    List<Trend> getLastTrends();

}
