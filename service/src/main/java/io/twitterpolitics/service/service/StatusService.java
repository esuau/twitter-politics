package io.twitterpolitics.service.service;

import io.twitterpolitics.entity.Status;

import java.util.List;

public interface StatusService {

    List<Status> findAll();

}
