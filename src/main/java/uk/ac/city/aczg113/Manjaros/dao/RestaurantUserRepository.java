package uk.ac.city.aczg113.Manjaros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczg113.Manjaros.entities.RestaurantUser;

/**
 * Class to access the database table backing the OperaUser entity.
 */
@Repository
public interface RestaurantUserRepository extends JpaRepository<RestaurantUser, String> {
}
