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
public class ProfileServiceImpl implements ProfileService {


    /**
     * The repository for booking data.
     */
    private RestaurantUserRepository restaurantUserRepository;
    /**
     * The repository for login history.
     */
    private FeedbackRepository feedbackRepository;
    /**
     *
     * Constructor based dependency injection of repositories.
     *
     * @param restaurantUserRepository the booking repo
     * @param feedbackRepository the login history repo
     */
    @Autowired
    public ProfileServiceImpl(RestaurantUserRepository restaurantUserRepository,
                              FeedbackRepository feedbackRepository){
        this.restaurantUserRepository = restaurantUserRepository;
        this.feedbackRepository = feedbackRepository;
    }

    /**
     * The implemented method that collates all the current users information
     * into a single object that will back the profile.html view
     *
     * @param email the current user's email
     * @return CollatedUser a object that aggregates all the user's data.
     */
    @Override
    public CollatedUser getProfile(String email) {
        CollatedUser user = new CollatedUser();
        user.setRestaurantUser(restaurantUserRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));
        List<Feedback> feedbacks = feedbackRepository.findAll()
                .stream().filter(viewing -> viewing.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setFeedback(feedbacks);
        return user;
    }
}
