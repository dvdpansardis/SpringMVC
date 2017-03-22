/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.controllers;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author David
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/message")
    public String message(){
        return "hello";
    }
    
    @RequestMapping("/messageByServer")
    public String messageByServer(Model model){
        model.addAttribute("message", "hello world");
        return "messageByServer";
    }
    
    @RequestMapping("/messageByServerV2")
    public ModelAndView messageByServerV2(){
        return new ModelAndView("messageByServer", "message", new Date().toString());
    }
    
    @RequestMapping("/receiveMessage/{message}")
    public String receiveMessage(Model model, @PathVariable("message") String message){
        model.addAttribute("message", message);
        return "messageByServer";
    }
    
    @RequestMapping("/receiveMessageV2")
    public String receiveMessageV2(Model model, @RequestParam(value = "message") String message){
        model.addAttribute("message", message);
        return "messageByServer";
    }
}
