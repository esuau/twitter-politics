package io.twitterpolitics.service.controller;

import io.twitterpolitics.entity.Status;
import io.twitterpolitics.service.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller managing the RESTful tweet API.
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    /**
     * Serves all the stored tweets.
     *
     * @return the list of stored tweets.
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Status> all() {
        return statusService.findAll();
    }

    /**
     * Serves the tweets of the day posted during breakfast time.
     *
     * @return the list of the tweets posted between 7AM and 9AM.
     */
    @GetMapping("/morning")
    @ResponseBody
    public List<Status> morning() {
        return statusService.getMorningTweets();
    }

}