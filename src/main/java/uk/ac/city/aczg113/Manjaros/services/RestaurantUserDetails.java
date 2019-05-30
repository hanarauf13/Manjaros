package uk.ac.city.aczg113.Manjaros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczg113.Manjaros.dao.RestaurantUserRepository;
import uk.ac.city.aczg113.Manjaros.entities.RestaurantUser;

import java.util.ArrayList;

@Service
public class RestaurantUserDetails implements UserDetailsService {

    private RestaurantUserRepository restaurantUserRepository;

    @Autowired
    public RestaurantUserDetails(RestaurantUserRepository restaurantUserRepository) {
        this.restaurantUserRepository = restaurantUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        RestaurantUser restaurantUser = restaurantUserRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching user."));
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(restaurantUser.getAuthority()));
        return new User
            (restaurantUser.getEmail(), restaurantUser.getFirstName(), restaurantUser.getEnabled(),
                    true, true, true, authorities);
    }
}