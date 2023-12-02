package personal.bonnycasi.eurekaclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import personal.bonnycasi.eurekaclient.services.TestoutService;

@RestController
public class SubController {
    @Autowired
    private TestoutService testoutService;

    @GetMapping("/something")
    public String getSomething() {
        return "something " + testoutService.otherStuff();
    }
}
