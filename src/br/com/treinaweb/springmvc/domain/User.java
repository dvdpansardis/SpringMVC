/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinaweb.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author David
 */
@Entity
@Table(name = "usr_users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "usr_user_name", length = 10, nullable = false)
    @Size(min = 3, max = 10, message = "The size this field must be between 3 and 10 chars.")
    @NotEmpty(message = "This field not be empty.")
    private String username;
    
    @Column(name = "usr_password", length = 150, nullable = false)
    @Size(min = 3, max = 150, message = "The size this field must be between 3 and 150 chars.")
    @NotEmpty(message = "This field not be empty.")
    private String password;
    
    @Column(name = "usr_role", length = 20, nullable = false)
    @NotEmpty(message = "This field not be empty.")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
