package io.twitterpolitics.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The controller managing the authentication.
 */
@Controller
public class AuthentificationController {

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
