package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface GreetingService {

     Greeting addGreeting(User user);
     Greeting getGreetingById(Long id);
     List<Greeting> getAllGreetingMessage();
     Optional<Greeting> updateGreeting(Greeting greeting, Long id);
}
