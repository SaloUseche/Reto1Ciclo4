package com.Back.Reto1Ciclo4.Interface;

import com.Back.Reto1Ciclo4.Entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Home
 */
public interface UserCrud extends CrudRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    //Optional<User> findByName(String name);
}
