package com.dags.displayinguserfeeback.controller;

import com.dags.displayinguserfeeback.domain.Feedback;
import com.dags.displayinguserfeeback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity postFeedback(@RequestBody Feedback feedback){

        if(feedbackService.createNewFeedback(feedback)){
            return new ResponseEntity(HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/feedback")
    public ResponseEntity getAllFeedback(){
        return new ResponseEntity<>(feedbackService.getAll(), HttpStatus.OK);
    }

}
