package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreetingMessage() {
        return greetingRepository.findAll();
    }

    public Optional<Greeting> updateGreeting(Greeting greeting, Long id) {
        Optional<Greeting> greetingObject = greetingRepository.findById(id);
        greetingObject.get().setMessage(greeting.getMessage());
        greetingRepository.save(greetingObject.get());
        return greetingObject;
    }

    @Override
    public String deleteGreetingMessageById(Long id) {
        greetingRepository.deleteById(id);
        return "Deleted greeting message!!";
    }
}
