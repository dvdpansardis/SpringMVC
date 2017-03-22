/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.security;

import br.com.treinaweb.springmvc.domain.User;
import br.com.treinaweb.springmvc.repositories.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author David
 */
public class TreinaWebSpringMVCDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(string);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        Set<GrantedAuthority> profils = new HashSet<>();
        profils.add(new SimpleGrantedAuthority(user.getRole()));
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), profils);
    }
}
