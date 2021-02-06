package com.dags.displayinguserfeeback.service;

import com.dags.displayinguserfeeback.domain.Feedback;
import com.dags.displayinguserfeeback.respository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public boolean createNewFeedback(Feedback feedback){

        if( feedback.getUsername() == null || feedback.getResponse() == null || feedback.getResponse().isBlank()
                || feedback.getUsername().isBlank())
            return false;

        feedbackRepository.save(feedback);

        return true;
    }

    public Iterable<Feedback> getAll(){
        return feedbackRepository.findAll();
    }

}
