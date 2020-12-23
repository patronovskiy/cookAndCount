package com.cookAndCount.cookAndCount;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

import com.cookAndCount.cookAndCount.domain.FoodItem;
import com.cookAndCount.cookAndCount.domain.FoodItemsList;
import com.cookAndCount.cookAndCount.repositories.FoodItemRepository;
import com.cookAndCount.cookAndCount.repositories.FoodItemsListRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FoodItemsListRepositoryTest {

    @Autowired
    private FoodItemsListRepository foodItemsListRepository;
    @Autowired
    private FoodItemRepository foodItemRepository;

    //заполняет специальную in-memory БД данными для тестов
    @Before
    public void setUp() throws Exception{
        FoodItem foodItem1 = new FoodItem("apple", 1.0,1.0,1.0,1.0);
        FoodItem foodItem2 = new FoodItem("pear", 2.0,2.0,2.0,2.0);
        FoodItem foodItem3 = new FoodItem("banana", 3.0,3.0,3.0,3.0);

        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(foodItem1);
        foodItems.add(foodItem2);
        foodItems.add(foodItem3);
        foodItemRepository.saveAll(foodItems);

        List<FoodItemsList> foodItemsListTest = Arrays.asList(
            new FoodItemsList(foodItem1, 100),
            new FoodItemsList(foodItem2, 0),
            new FoodItemsList(foodItem3, 1)
        );

        foodItemsListRepository.saveAll(foodItemsListTest);
    }

    //после теста удаляет всё из БД
    @After
    public void tearDown() throws Exception{
        foodItemsListRepository.deleteAll();
        foodItemRepository.deleteAll();
    }

    @Test
    public void testFindAll(){
        List<FoodItemsList> all = foodItemsListRepository.findAll();

        //значение можно поменять на значение, отличное от 3, чтобы тест был заведомо провальный
        assertEquals(3, all.size());
    }
}
