package io.twitterpolitics.service.service;

import io.twitterpolitics.repository.StatusRepository;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class StatusServiceImplTest {

    @Mock
    private StatusRepository statusRepository;

    @InjectMocks
    private StatusServiceImpl statusService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private Object[] parametersForGetMorningTimeReturnCorrectValues() {
        Date today = new Date(1520852400000L);
        return new Object[][] {
            { today, "start", new Date(1520834400000L) },
            { today, "end", new Date(1520841600000L) }
        };
    }

    @Test
    @Parameters
    public void getMorningTimeReturnCorrectValues(Date date, String startOrEnd, Date expected) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = StatusServiceImpl.class.getDeclaredMethod("getMorningTime", Date.class, String.class);
        method.setAccessible(true);
        assertEquals(expected, method.invoke(statusService, date, startOrEnd));
    }

}