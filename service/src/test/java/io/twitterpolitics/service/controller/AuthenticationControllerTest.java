package io.twitterpolitics.service.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticationControllerTest {

    private AuthenticationController authenticationController = new AuthenticationController();

    @Test
    public void checkConnectionReturnsTrue() {
        assertEquals(false, authenticationController.checkConnection("password"));
        assertEquals(true, authenticationController.checkConnection("macron2018"));
    }
}