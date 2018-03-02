package io.twitterpolitics.scraper.service;

import io.twitterpolitics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScraperServiceImpl implements ScraperService {

    @Autowired
    private StatusRepository statusRepository;

    private ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
            .setDebugEnabled(true)
            .setOAuthConsumerKey("consumerKey")
            .setOAuthConsumerSecret("consumerSecret")
            .setOAuthAccessToken("accessToken")
            .setOAuthAccessTokenSecret("accessTokenSecret");

    private Configuration configuration = configurationBuilder.build();

    private Twitter twitter = new TwitterFactory(configuration).getInstance();

    private TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();

    private Trends trends;

    @Override
    public void getTrends() throws TwitterException {
        trends = twitter.getPlaceTrends(23424819);
    }

    @Override
    @Transactional
    public void saveStatuses() throws TwitterException {
        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.track(getTrendQueries());
        twitterStream.addListener(new StatusListener() {
            @Override
            public void onStatus(Status status) {
                io.twitterpolitics.entity.Status scraperStatus = new io.twitterpolitics.entity.Status();
                scraperStatus.setId(status.getId());
                scraperStatus.setCreatedAt(status.getCreatedAt());
                scraperStatus.setText(status.getText());
                io.twitterpolitics.entity.User scraperUser = new io.twitterpolitics.entity.User();
                scraperUser.setId(status.getUser().getId());
                scraperUser.setName(status.getUser().getName());
                scraperUser.setScreenName(status.getUser().getScreenName());
                scraperUser.setProfileImageUrl(status.getUser().getProfileImageURL());
                scraperStatus.setUser(scraperUser);
                statusRepository.save(scraperStatus);
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int i) {

            }

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }

            @Override
            public void onException(Exception e) {

            }
        });
        twitterStream.filter(tweetFilterQuery);
    }

    private String[] getTrendQueries() throws TwitterException {
        getTrends();
        List<String> queryList = new ArrayList<>();
        for (Trend trend : trends.getTrends()) {
            queryList.add(trend.getQuery());
        }
        String[] queries = new String[queryList.size()];
        return queryList.toArray(queries);
    }

}
