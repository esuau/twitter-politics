package io.twitterpolitics.service.service;

import io.twitterpolitics.entity.Status;
import io.twitterpolitics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

}
