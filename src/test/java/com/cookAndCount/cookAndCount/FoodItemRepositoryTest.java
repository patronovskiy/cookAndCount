package com.cookAndCount.cookAndCount;

import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class FoodItemRepositoryTest {

    @Autowired
    private FoodItemRepository foodItemRepository;

    //заполняет специальную in-memory БД данными для тестов
    @Before
    public void setUp() throws Exception{
        List<FoodItem> foodItemsTest = Arrays.asList(
                new FoodItem("apple", 1.0,1.0,1.0,1.0),
                new FoodItem("pear", 2.0,2.0,2.0,2.0),
                new FoodItem("banana", 3.0,3.0,3.0,3.0)
        );
        foodItemRepository.saveAll(foodItemsTest);
    }

    //после теста удаляет всё из БД
    @After
    public void tearDown() throws Exception{
        foodItemRepository.deleteAll();
    }

    @Test
    public void testFindAll(){
        List<FoodItem> all = foodItemRepository.findAll();

        //значение можно поменять на значение, отличное от 3, чтобы тест был заведомо провальный
        assertEquals(3, all.size());
    }
}