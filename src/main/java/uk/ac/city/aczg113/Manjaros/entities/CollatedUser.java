package uk.ac.city.aczg113.Manjaros.entities;

import java.util.List;

public class CollatedUser {
    private RestaurantUser restaurantUser;

    public RestaurantUser getRestaurantUser() {
        return restaurantUser;
    }

    public void setRestaurantUser(RestaurantUser restaurantUser) {
        this.restaurantUser = restaurantUser;
    }

    private List<Feedback> feedbacks;

    public List<Feedback> getFeedback() {
        return feedbacks;
    }

    public void setFeedback(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

}
