package com.ratpack.downloadhound.data.service;

import com.ratpack.downloadhound.data.entity.User;
import com.ratpack.downloadhound.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        Iterable<User> users = this.userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(user->{
            userList.add(user);
        });
        return userList;
    }

    public void changeUserStatus (Long id){
        User user = this.userRepository.findOne(id);
        if(user.isActive()){
            user.setActive(false);
        } else {
            user.setActive(true);
        }
        this.userRepository.save(user);
    }

    public void upsertUser(User user){
        this.userRepository.save(user);
    }

    public User getUserById(Long id){
        User user = this.userRepository.findOne(id);
        return user;
    }

    public boolean userExist(User user){

        User user1 = this.userRepository.findByUserAccount(user.getUserAccount());
        User user2 = this.userRepository.findByEmail(user.getEmail());

        if(user1 == null){
            if(user2 == null){
                return false;
            }
        }
        return true;
    }
}
