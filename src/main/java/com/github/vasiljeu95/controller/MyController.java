package com.github.vasiljeu95.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MyController
 *
 * @author Stepan Vasilyeu
 * @since 13.09.2022
 */
@Controller
public class MyController {
    @GetMapping("/")
    public String getInfoForAllEmps() {
        return "viewForAllEmployees";
    }

    @GetMapping("/hrInfo")
    public String getInfoOnlyForHR() {
        return "viewForHR";
    }

    @GetMapping("managerInfo")
    public String getInfoOnlyForManagers() {
        return "viewForManagers";
    }
}
