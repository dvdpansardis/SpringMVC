/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author David
 */
@Controller
@RequestMapping("/home/")
public class HomeController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "home.login.tiles";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        return "home.welcome.tiles";
    }   
}
