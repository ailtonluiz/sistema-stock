package com.ailtonluiz.sgs.service;


import com.ailtonluiz.sgs.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ailtonluiz.sgs.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private Users users;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = users.findByName(s);

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), roles);

        return userDetails;
    }
}
