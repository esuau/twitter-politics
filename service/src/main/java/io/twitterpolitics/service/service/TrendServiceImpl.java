package io.twitterpolitics.service.service;

import io.twitterpolitics.entity.Trend;
import io.twitterpolitics.repository.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrendServiceImpl implements TrendService {

    @Autowired
    private TrendRepository trendRepository;

    @Override
    public List<Trend> getLastTrends() {
        return trendRepository.findAll(new Sort(Sort.Direction.DESC, "id")).subList(0, 9);
    }

}
