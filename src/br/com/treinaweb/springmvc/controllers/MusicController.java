/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.controllers;

import br.com.treinaweb.springmvc.domain.Music;
import br.com.treinaweb.springmvc.repositories.AlbumRepository;
import br.com.treinaweb.springmvc.repositories.MusicRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author David
 */
@Controller
@RequestMapping(path = "/musics/")
public class MusicController {
    
    @Autowired
    private AlbumRepository albumRepository;
    
    @Autowired
    private MusicRepository musicRepository;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("musics", musicRepository.findAll());
        return "musics.list.tiles";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("music", new Music());
        model.addAttribute("albuns", albumRepository.findAll());
        return "musics.create.tiles";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("music") @Valid Music music, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("albuns", albumRepository.findAll());
            return "musics.create.tiles";
        }
        musicRepository.save(music);
        return "redirect:/musics/list";
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model){
        Music music = musicRepository.findOne(id);
        model.addAttribute("albuns", albumRepository.findAll());
        model.addAttribute("music", music);
        return "musics.update.tiles";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("music") @Valid Music music, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("albuns", albumRepository.findAll());
            return "musics.update.tiles";
        }
        musicRepository.save(music);
        return "redirect:/musics/list";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        Music music = musicRepository.findOne(id);
        music.setAlbum(null);
        musicRepository.delete(music);
        return "redirect:/musics/list";
    }

}
