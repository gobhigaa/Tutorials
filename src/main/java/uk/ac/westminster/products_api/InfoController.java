package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/info")
    public String getInfo() {
        return "This application is a Spring Boot demo built for the 5COSC019W coursework and tutorials.";
    }
}
