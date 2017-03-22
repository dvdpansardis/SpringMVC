/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author David
 */
@Entity
@Table(name = "alb_album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alb_id")
    private Long id;
    
    @NotNull(message = "This field not is empty.")
    @NotEmpty(message = "This field not is empty.")
    @Size(min = 4, max = 20, message = "This field should have between 4 and 20 chars.")
    @Column(name = "alb_name", length = 100, nullable = false)
    private String name;
    
    @NotNull(message = "This field not is empty.")
    @Min(value = 1980, message = "This field must be after 1980.")
    @Column(name = "alb_release_year", nullable = false)
    private Integer releaseYear;

    @JsonBackReference
    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    Set<Music> musics;

    public Set<Music> getMusics() {
        return musics;
    }

    public void setMusics(Set<Music> musics) {
        this.musics = musics;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
