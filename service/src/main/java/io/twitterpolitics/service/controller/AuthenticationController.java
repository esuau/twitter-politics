package io.twitterpolitics.service.controller;

import org.springframework.web.bind.annotation.*;

/**
 * The controller managing the authentication.
 */
@CrossOrigin
@RestController
public class AuthenticationController {

    /**
     * Checks if submitted password is correct.
     *
     * @param password the submitted password.
     * @return true if the password is correct; false if not.
     */
    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public boolean checkConnection(@RequestBody String password) {
        return "macron2018".equals(password);
    }

}
