package io.twitterpolitics.service.controller;

import io.twitterpolitics.entity.Trend;
import io.twitterpolitics.service.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * The controller serving the trends.
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/trends")
public class TrendController {

    @Autowired
    private TrendService trendService;

    @GetMapping
    @ResponseBody
    public List<Trend> getTrendingTopics() {
        return trendService.getLastTrends();
    }

}
