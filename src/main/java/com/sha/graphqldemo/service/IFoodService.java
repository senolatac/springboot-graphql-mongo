package com.sha.graphqldemo.service;

import com.sha.graphqldemo.model.Food;
import graphql.schema.DataFetchingEnvironment;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.execution.ResolutionEnvironment;

import java.util.List;
import java.util.Optional;

/**
 * @author sa
 * @date 25.02.2021
 * @time 12:34
 */
public interface IFoodService
{
    List<Food> getFoods(@GraphQLEnvironment ResolutionEnvironment env);

    Optional<Food> getFoodById(@GraphQLArgument(name = "id") Long id);

    Food saveFood(@GraphQLArgument(name = "food") Food food);

    void deleteFood(@GraphQLArgument(name = "id") Long id);

    boolean isGood(@GraphQLContext Food food);
}
