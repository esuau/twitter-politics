package io.twitterpolitics.scraper.service;

import io.twitterpolitics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScraperServiceImpl implements ScraperService {

    @Autowired
    private StatusRepository statusRepository;

    private Twitter twitter = new TwitterFactory().getInstance();

    private TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

    private Trends trends;

    @Override
    @Scheduled(fixedRate = 60000)
    public void getTrends() throws TwitterException {
        trends = twitter.getPlaceTrends(23424819);
    }

    @Override
    public void saveStatuses() throws TwitterException {
        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.track(getTrendQueries());
        tweetFilterQuery.language("fr");
        twitterStream.addListener(new StatusListener() {
            @Override
            @Transactional
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
