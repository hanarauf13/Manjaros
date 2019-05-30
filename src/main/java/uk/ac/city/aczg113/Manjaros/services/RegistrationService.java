package uk.ac.city.aczg113.Manjaros.services;

import uk.ac.city.aczg113.Manjaros.entities.RestaurantUser;

import java.util.List;

public interface RegistrationService {


    List<RestaurantUser> getUsers();
    void addUser(RestaurantUser restaurantUser);
    RestaurantUser getCurrentUser();
    int getNumberOfUsers();

}
