package io.twitterpolitics.service.service;

import io.twitterpolitics.entity.Status;
import io.twitterpolitics.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll(new Sort(Sort.Direction.DESC, "createdAt"));
    }

    @Override
    public List<Status> getMorningTweets() {
        Date date = new Date();
        return statusRepository.getBreakfastTweets(getMorningTime(date, "start"), getMorningTime(date, "end"));
    }

    /**
     * Gets the breakfast start date.
     *
     * @param today today's date.
     * @return the date of the
     */
    private Date getMorningTime(Date today, String endOrStart) {
        int hour = "start".equals(endOrStart) ? 7 : 9;
        Calendar calendarStart = Calendar.getInstance(TimeZone.getTimeZone("CET"));
        calendarStart.setTime(today);
        calendarStart.set(Calendar.HOUR_OF_DAY, hour);
        calendarStart.set(Calendar.MINUTE, 0);
        calendarStart.set(Calendar.SECOND, 0);
        calendarStart.set(Calendar.MILLISECOND, 0);
        return calendarStart.getTime();
    }

}
