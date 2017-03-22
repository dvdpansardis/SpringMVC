/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import br.com.treinaweb.springmvc.domain.User;
import br.com.treinaweb.springmvc.repositories.UserRepository;
import javax.annotation.Resource;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author David
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "/WEB-INF/web.xml")
@ActiveProfiles("test")
@ContextConfiguration(locations = {
    "file:WebContent/WEB-INF/TreinaWebSpringMVC-servlet.xml"
})
public class UserTest {
    
    @Resource(name = "userRepository")
    private UserRepository userRepository;

    public UserTest(){
        
    }
    
    @Test
    public void testUserIsFiend(){
        User user = userRepository.findByUsername("dvd");
        
        if(user != null)
            assertTrue("This will succeed.", true);
    }
}
