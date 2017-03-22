/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.controllers;

import br.com.treinaweb.springmvc.domain.User;
import br.com.treinaweb.springmvc.repositories.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author David
 */
@Controller
@RequestMapping(path = "/users/")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users.list.tiles";
    }
    
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("user", new User());
        return "users.create.tiles";
    }
    
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("user") @Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "users.create.tiles";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/users/list";
    }
}
