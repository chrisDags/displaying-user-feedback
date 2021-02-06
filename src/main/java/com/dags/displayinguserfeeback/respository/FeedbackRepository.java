package com.dags.displayinguserfeeback.respository;

import com.dags.displayinguserfeeback.domain.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
}
