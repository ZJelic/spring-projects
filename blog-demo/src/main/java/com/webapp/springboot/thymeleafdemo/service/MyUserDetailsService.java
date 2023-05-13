package com.webapp.springboot.thymeleafdemo.service;


import com.webapp.springboot.thymeleafdemo.dao.UserRepository;
import com.webapp.springboot.thymeleafdemo.entity.User;
import com.webapp.springboot.thymeleafdemo.models.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("User not found!");
        }
        //so what do we return? So we would create a class that implements UserDetails

        return new UserPrincipal(user) {
        };

    }
}
