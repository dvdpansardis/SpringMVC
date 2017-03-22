/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.controllers;

import br.com.treinaweb.springmvc.domain.Album;
import br.com.treinaweb.springmvc.repositories.AlbumRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author David
 */
@Controller
@RequestMapping("/albuns")
public class AlbumController {
    
    @Autowired
    private AlbumRepository albumRepository;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        List<Album> albuns = albumRepository.findAll();
        model.addAttribute("albuns", albuns);
        return "album.list.tiles";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("album", new Album());
        return "album.create.tiles";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("album") @Valid Album album, BindingResult result, Model model){
        if(result.hasErrors())
            return "album.create.tiles";
        //model.addAttribute("album", album);
        albumRepository.save(album);
        return "redirect:/albuns/list";
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model){
        Album album = albumRepository.findOne(id);
        model.addAttribute("album", album);
        return "album.update.tiles";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("album") @Valid Album album, BindingResult result){
        if(result.hasErrors()){
            return "album.update.tiles";
        }
        albumRepository.save(album);
        return "redirect:/albuns/list";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        albumRepository.delete(id);
        return "redirect:/albuns/list";
    }
    
    @RequestMapping(value = "/listByName", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Album> list(@RequestParam(name = "name", defaultValue = "") String name){
        return albumRepository.findByName(name);
    }
}
