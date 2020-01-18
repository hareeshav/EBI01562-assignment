package com.hareesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hareesh.demo.dao.PersonDao;
import com.hareesh.demo.dao.UserDao;
import com.hareesh.demo.model.Person;
import com.hareesh.demo.model.User;

@SpringBootApplication
public class SpringBootServiceApplication {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserDao userDao, PersonDao personDao){
    	//Setting a default admin user on startup & one person
        return args -> {
            User user = new User();
            user.setUsername("hareesh");
            user.setPassword(passwordEncoder.encode("admin"));
            userDao.save(user);
            
            Person person = new Person();
            person.setFirstName("test");
            person.setLastName("test");
            person.setAge(25);
            person.setFavColour("Orange");
            person.setHobbies(new String[]{"Football","Shopping"});
            personDao.save(person);

        };
    }

}
