package uk.ac.city.aczg113.Manjaros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg113.Manjaros.dao.FeedbackRepository;
import uk.ac.city.aczg113.Manjaros.dao.RestaurantUserRepository;
import uk.ac.city.aczg113.Manjaros.entities.CollatedUser;
import uk.ac.city.aczg113.Manjaros.entities.Feedback;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository feedbackRepository;
    private RestaurantUserRepository restaurantUserRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, RestaurantUserRepository restaurantUserRepository){
        this.feedbackRepository = feedbackRepository;
        this.restaurantUserRepository = restaurantUserRepository;
    }


    @Override
    public void makeFeedback(Feedback feedback){ feedbackRepository.save(feedback);}

    @Override
    public CollatedUser getFeedback(String email){
        CollatedUser collatedUser = new CollatedUser();
        collatedUser.setRestaurantUser(restaurantUserRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No Matching User Found")));
        List<Feedback> feedbacks = feedbackRepository.findAll()
                .stream().filter(feedback -> feedback.getEmail().equals(email))
                .collect(Collectors.toList());
        collatedUser.setFeedback(feedbacks);
        return collatedUser;
    }
}
