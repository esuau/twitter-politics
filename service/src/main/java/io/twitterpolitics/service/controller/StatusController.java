package io.twitterpolitics.service.controller;

import io.twitterpolitics.entity.Status;
import io.twitterpolitics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/status")
public class StatusController {

    @GetMapping
    @ResponseBody
    public List<Status> hello() {
        Status status1 = new Status();
        status1.setId(1);
        status1.setCreatedAt(new Date());
        status1.setText("Hello World !");
        status1.setAuthor("Evan Suau");
        Status status2 = new Status();
        status2.setId(2);
        status2.setCreatedAt(new Date());
        status2.setText("Hey !");
        status2.setAuthor("Noel Diril");
        return new ArrayList<>(Arrays.asList(status1, status2));
    }

}