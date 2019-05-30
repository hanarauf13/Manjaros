package uk.ac.city.aczg113.Manjaros.services;

import uk.ac.city.aczg113.Manjaros.entities.CollatedUser;

/**
 * Profile service interface that specifies a method to return a CollatedUser.
 */
public interface ProfileService {

    CollatedUser getProfile(String email);
}
