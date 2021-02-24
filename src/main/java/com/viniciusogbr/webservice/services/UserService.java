package com.viniciusogbr.webservice.services;

import com.viniciusogbr.webservice.entities.User;
import com.viniciusogbr.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optional =  userRepository.findById(id);
        return optional.get();
    }

    public User insert(User user) {
       return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        //Apenas prepara o objeto user para depois fazer alguma modificação no banco de dados
        User entity = userRepository.getOne(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    //Atualizar entity com base nos dados que chegaram no obj
    private void updateData(User entity, User obj) {
        entity.setEmail(obj.getEmail());
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }
}