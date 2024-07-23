package com.kitri.myspringboard.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/admin")
    public String admin (){
        return "admin page";
    }

    @GetMapping("/user")
    public String user() {
        return "user page";
    }

    @GetMapping("/any")
    public String any() {
        return "any page";
    }
}
