package com.sha.graphqldemo.repository;

import com.sha.graphqldemo.model.Food;

import java.util.List;
import java.util.Set;

/**
 * @author sa
 * @date 26.02.2021
 * @time 09:53
 */
public interface FoodCustomRepository
{
    List<Food> findCustomAll(Set<String> selectedFields);
}
