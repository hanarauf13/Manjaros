package uk.ac.city.aczg113.Manjaros.entities;

import java.nio.file.attribute.UserPrincipal;

public class RestaurantUserPrincipal implements UserPrincipal {
    private RestaurantUser restaurantUser;
    public RestaurantUserPrincipal(RestaurantUser restaurantUser){
        this.restaurantUser=restaurantUser;
    }
    @Override
    public String getName(){return restaurantUser.getEmail();}
}
