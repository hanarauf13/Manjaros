package uk.ac.city.aczg113.Manjaros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg113.Manjaros.dao.RestaurantUserRepository;
import uk.ac.city.aczg113.Manjaros.entities.RestaurantUser;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private RestaurantUserRepository restaurantUserRepository;
    private RestaurantUser currentUser;

    @Autowired
    public RegistrationServiceImpl(RestaurantUserRepository restaurantUserRepository){
    this.restaurantUserRepository = restaurantUserRepository;
        RestaurantUser user = new RestaurantUser("Ann","company", "ann@company","pass1");
        user.setEnabled(Boolean.TRUE);
        user.setAuthority("ROLE_USER");
        restaurantUserRepository.save(user);
    }
    @Override
    public List<RestaurantUser> getUsers(){return restaurantUserRepository.findAll(); }

    @Override
    public void addUser(RestaurantUser restaurantUser) {
    currentUser = restaurantUser;
    restaurantUserRepository.save(restaurantUser);
    }

    @Override
    public RestaurantUser getCurrentUser(){
        return currentUser;}

    @Override
    public int getNumberOfUsers(){ return (int)restaurantUserRepository.count();}


}
