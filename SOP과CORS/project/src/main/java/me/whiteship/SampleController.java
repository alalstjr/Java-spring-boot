package me.whiteship;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    //@CrossOrigin("http://localhost:18080")
    public String hello() {
        return "hello";
    }
}
