package com.KST.TheNetwork.service;

import com.KST.TheNetwork.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final String USERNAME_NOT_FOUND_MSG="User with the given username '%s' cannot be found.";

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userService.findByUsername(username)
               .orElseThrow(()-> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_MSG,username)));
    }

}
