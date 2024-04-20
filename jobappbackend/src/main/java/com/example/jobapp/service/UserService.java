package com.example.jobapp.service;

import com.example.jobapp.model.Role;
import com.example.jobapp.model.User;
import com.example.jobapp.model.UserRole;
import com.example.jobapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {


    public void assignRolesToUser(User user, List<UserRole> roles) {
        user.setRoleList(roles);
        userRepository.save(user);
    }
        private final UserRepository userRepository;
//        public UserService(UserRepository userRepository) {
//            this.userRepository = userRepository;
//        }


        public UserDetails loadUserByUsername(String username) {
            User user = userRepository.findByName(username);
            if (user == null) {
                throw new UsernameNotFoundException("User " + username + " not found..!");
            }
            return user;


        }

        public User registerUser(User user) {
            return userRepository.save(user);
        }


        public User getUserById(Long id) {
            return userRepository.findById(id).orElse(null);
        }


        public List<User> getAllUsers() {
            return userRepository.findAllByDeletedIsNull();
        }


        public User userUpdate(User user) {
            User existingUser = userRepository.findById(user.getId()).orElse(null);
            if (existingUser != null) {existingUser.setName(user.getName());
                existingUser.setEmail(user.getEmail());
                existingUser.setPassword(user.getPassword());
                existingUser.setPhone(user.getPhone());
                existingUser.setRoleList(user.getRoleList());
                return existingUser;
            }else{
                return null;
            }
        }

        public User deleteUserById(Long id) {
            /*userRepository.deleteById(id);*/
            User existingUser = userRepository.findById(id).orElse(null);
            if (existingUser != null) {
                existingUser.setDeleted(LocalDateTime.now());
                return userRepository.save(existingUser);
            }else {
                return null;
            }
        }

        public User getUsername(String username) {
            return userRepository.findByName(username);
        }

}
