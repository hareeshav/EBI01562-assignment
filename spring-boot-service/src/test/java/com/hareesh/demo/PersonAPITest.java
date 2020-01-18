package com.hareesh.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hareesh.demo.model.Person;
import com.hareesh.demo.service.PersonService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PersonAPITest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void findAll() throws Exception {
        // given
    	 Person person = new Person();
         person.setFirstName("test");
         //person.setLastName("test");
         //person.setAge(25);
        // person.setFavColour("Orange");
         //person.setHobbies(new String[]{"Football","Shopping"});

        List<Person> persons = Arrays.asList(person);
        given(personService.findAll()).willReturn(persons);

        // when + then
        this.mockMvc.perform(get("/persons"))
                .andExpect(status().isOk());
                //.andExpect(content().json("[{'id': 1,'firstName': 'test'}]"));
    }

}
