package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.User;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = { "/", "message", ""})
    public Greeting greetingMessage(@RequestParam(required = false, defaultValue = "") String firstName,@RequestParam(required = false,  defaultValue = "") String lastName) {
          //  return new Greeting(counter.incrementAndGet(), String.format(template, firstName, lastName));
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/getid/{id}")
    public Greeting findGreetingById(@PathVariable Long id) {

        return greetingService.getGreetingById(id);
    }

    @GetMapping("/getallgreeting")
    public List<Greeting> getAllGreetingMessage() {
        return greetingService.getAllGreetingMessage();
    }

    @PutMapping("/update/{id}")
    public Optional<Greeting> updateGreeting(Greeting greeting, @PathVariable("id") Long id) {
        return greetingService.updateGreeting(greeting, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreetingMessageById(@PathVariable Long id) {
        return greetingService.deleteGreetingMessageById(id);
    }
}
