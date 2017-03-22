/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.repositories;

import br.com.treinaweb.springmvc.domain.Album;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author David
 */
public interface AlbumRepository extends JpaRepository<Album, Long>{
    
    @Query("SELECT a FROM Album a WHERE name LIKE %:name%")
    public List<Album> findByName(@Param("name") String name);
     
}
