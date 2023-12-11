package com.rebolledonaharro.dinoapi.usuario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("personDetailsService")
@RequiredArgsConstructor
public class CustomPersonDetailsService implements UserDetailsService {


    private final PersonService personService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return personService.findByUsername(username)
                .orElseThrow(
                        ()->new UsernameNotFoundException("No user with the username: "+ username)
                );
    }

}
