package io.twitterpolitics.service.controller;

import io.twitterpolitics.entity.Status;
import io.twitterpolitics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "/status")
public class StatusController {

    @Autowired
    private StatusRepository repository;

    @GetMapping
    public @ResponseBody Status hello() {
        Status status = new Status();
        status.setId(1);
        status.setCreatedAt(new Date());
        status.setText("Hello World !");
        return status;
    }

}