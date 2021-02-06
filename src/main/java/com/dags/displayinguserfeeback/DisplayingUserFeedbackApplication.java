package com.dags.displayinguserfeeback;

import com.dags.displayinguserfeeback.domain.Feedback;
import com.dags.displayinguserfeeback.respository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DisplayingUserFeedbackApplication implements CommandLineRunner {

    @Autowired
    FeedbackRepository feedbackRepository;


    public static void main(String[] args) {
        SpringApplication.run(DisplayingUserFeedbackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Feedback feedback1 = Feedback.builder()
                .username("Foo1")
                .response("Everything about this company is terrible, I'm never buying from here again!")
                .build();

        Feedback feedback2 = Feedback.builder()
                .username("Foo2")
                .response("I had an amazing experience!")
                .build();

        Feedback feedback3 = Feedback.builder()
                .username("Foo3")
                .response("The product I purchased ended up being defective, but their customer " +
                        "support handled the issue quickly and I received a full refund")
                .build();

        feedbackRepository.save(feedback1);
        feedbackRepository.save(feedback2);
        feedbackRepository.save(feedback3);
    }
}
