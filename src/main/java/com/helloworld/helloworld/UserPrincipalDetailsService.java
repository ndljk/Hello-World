package com.helloworld.helloworld;

import com.helloworld.helloworld.model.User;
import com.helloworld.helloworld.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserService userService;

    public UserPrincipalDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.getByUsername(username);
        UserPrincipal userPrincipal= new UserPrincipal(user);

        return userPrincipal;
    }
}
