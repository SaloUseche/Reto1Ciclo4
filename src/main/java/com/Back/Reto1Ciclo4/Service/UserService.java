/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Back.Reto1Ciclo4.Service;

import com.Back.Reto1Ciclo4.Entity.User;
import com.Back.Reto1Ciclo4.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Home
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository serviceUser;
    
    public List<User> getAll(){
        return serviceUser.getAll();
    }
    
    public Optional<User> getUser(int id){
        return serviceUser.getUser(id);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return serviceUser.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return serviceUser.existeEmail(email);
    }
        public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = serviceUser.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
