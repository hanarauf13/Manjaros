package uk.ac.city.aczg113.Manjaros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczg113.Manjaros.entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String>{
}
