package apitoken.autenticacao.service;

import java.util.ArrayList;

import apitoken.autenticacao.model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //com.bootstrap.springboot.model.User user = userService.getByEmail(email);

        JwtRequest user = userService.getByEmail(email);

        if (user.getEmail().equals(email)) {
            return new User(email, user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
