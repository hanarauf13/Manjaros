package uk.ac.city.aczg113.Manjaros.services;

import uk.ac.city.aczg113.Manjaros.entities.CollatedUser;
import uk.ac.city.aczg113.Manjaros.entities.Feedback;
import uk.ac.city.aczg113.Manjaros.entities.RestaurantUser;

import java.util.List;

public interface FeedbackService {

    void makeFeedback(Feedback feedback);
    CollatedUser getFeedback(String email);

}
