package com.sha.graphqldemo.service;

import com.sha.graphqldemo.model.Food;
import com.sha.graphqldemo.repository.IFoodRepository;
import graphql.schema.SelectedField;
import io.leangen.graphql.annotations.*;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.metadata.Operation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import io.leangen.graphql.util.Directives;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.*;

/**
 * @author sa
 * @date 25.02.2021
 * @time 12:33
 */
@Service
@GraphQLApi
@RequiredArgsConstructor
public class FoodService
{
    private final IFoodRepository foodRepository;

    @GraphQLQuery(name = "foods") // READ ALL
    public List<Food> getFoods(@GraphQLEnvironment ResolutionEnvironment env) {
        return foodRepository.findAll(selectedFields(env));
    }

    @GraphQLQuery(name = "food") // READ BY ID
    public Optional<Food> getFoodById(@GraphQLArgument(name = "id") String id,
                                      @GraphQLEnvironment ResolutionEnvironment env) {
        return foodRepository.findById(id, selectedFields(env));
    }

    @GraphQLMutation(name = "saveFood") // CREATE
    public Food saveFood(@GraphQLArgument(name = "food") Food food) {
        return foodRepository.save(food);
    }

    @GraphQLMutation(name = "deleteFood") // DELETE
    public void deleteFood(@GraphQLArgument(name = "id") String id) {
        foodRepository.deleteById(id);
    }

    @GraphQLQuery(name = "isGood") // Calculated property of Food
    public boolean isGood(@GraphQLContext Food food) {
        return !Arrays.asList("Avocado", "Spam").contains(food.getName());
    }

    private Set<String> selectedFields(ResolutionEnvironment env)
    {
        Set<String> selectedFields = new HashSet<>();
        return selectedFields(env.dataFetchingEnvironment.getSelectionSet().getImmediateFields(), selectedFields, "");
    }

    private Set<String> selectedFields(List<SelectedField> requestedFields, Set<String> selectedFields, String prefix)
    {
        for (SelectedField f: requestedFields)
        {
            Optional<Operation> operation = Directives.getMappedOperation(f.getFieldDefinition());
            String originalName = operation.map(op -> ((Member) op.getTypedElement().getElement()).getName()).orElse(null);
            if (!f.getSelectionSet().getImmediateFields().isEmpty())
            {
                selectedFields(f.getSelectionSet().getImmediateFields(), selectedFields, prefix + originalName + ".");
            }
            else
            {
                selectedFields.add(prefix + originalName);
            }
        }
        return selectedFields;
    }
}
