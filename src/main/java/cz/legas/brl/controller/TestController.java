package cz.legas.brl.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "AHOJ";
    }
}
