package com.sha.graphqldemo.repository;

import com.sha.graphqldemo.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author sa
 * @date 25.02.2021
 * @time 12:33
 */
public interface IFoodRepository extends MongoRepository<Food, String>, FoodCustomRepository
{
}
