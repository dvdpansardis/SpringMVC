/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.repositories;

import br.com.treinaweb.springmvc.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David
 */
public interface MusicRepository extends JpaRepository<Music, Long> {

   
}
