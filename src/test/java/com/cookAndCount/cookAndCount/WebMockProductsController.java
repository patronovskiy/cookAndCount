package com.cookAndCount.cookAndCount;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //отключает WebSecurityConfig
public class WebMockProductsController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodItemRepository foodItemRepositoryMock;

    @Test
    public void itShouldReturnFoodItem()
            throws Exception {

        List<FoodItem> foodItemsTest = Arrays.asList(
                new FoodItem("apple", 1.0,1.0,1.0,1.0),
                new FoodItem("pear", 2.0,2.0,2.0,2.0),
                new FoodItem("banana", 3.0,3.0,3.0,3.0)
        );

        foodItemRepositoryMock.saveAll(foodItemsTest);

        when(foodItemRepositoryMock.findAll()).thenReturn(foodItemsTest);

        //можно поменять substring, чтобы тест проваливался
        mockMvc.perform(get("/products")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("apple")));

        foodItemRepositoryMock.deleteAll();
    }
}