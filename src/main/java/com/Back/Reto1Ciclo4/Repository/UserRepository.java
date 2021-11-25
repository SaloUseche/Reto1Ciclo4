package com.Back.Reto1Ciclo4.Repository;

import com.Back.Reto1Ciclo4.Entity.User;
import com.Back.Reto1Ciclo4.Interface.UserCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Home
 */
@Repository
public class UserRepository {
    
    
    @Autowired //<-- Implementacion de estar interfaz y la instancie
    private UserCrud userInterface;
    
    public List<User> getAll() {
        return (List<User>) userInterface.findAll();
    }
    
    public Optional<User> getUser(int id) {
        return userInterface.findById(id);
    }
    
    public User save(User user) {
        return userInterface.save(user);
    }
    
    public boolean ExisteEmail(String email) {
        Optional<User> usuario = userInterface.findByEmail(email);

        return !usuario.isEmpty();
    }
    
    public boolean existeEmail(String email) {
        Optional<User> usuario = userInterface.findByEmail(email);

        return !usuario.isEmpty();
    }


    public Optional<User> autenticarUsuario(String email, String password) {
        return userInterface.findByEmailAndPassword(email, password);
    }
}
