package io.twitterpolitics.scraper.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import twitter4j.Twitter;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScraperServiceImplTest {

    @Mock
    private Twitter twitter;

    @InjectMocks
    private ScraperService scraperService;

    @Test
    public void saveStatuses() {
    }
}