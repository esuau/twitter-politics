package io.twitterpolitics.service.controller;

import io.twitterpolitics.entity.Status;
import io.twitterpolitics.service.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    @ResponseBody
    public List<Status> hello() {
        return statusService.findAll();
    }

}