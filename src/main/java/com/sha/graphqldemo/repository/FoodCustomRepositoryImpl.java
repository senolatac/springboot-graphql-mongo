package com.sha.graphqldemo.repository;

import com.sha.graphqldemo.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author sa
 * @date 26.02.2021
 * @time 09:53
 */
@RequiredArgsConstructor
public class FoodCustomRepositoryImpl implements FoodCustomRepository
{
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Food> findAll(Set<String> selectedFields)
    {
        Query q = new Query();
        q.fields().include(selectedFields.toArray(String[]::new));
        return mongoTemplate.find(q, Food.class);
    }

    @Override
    public Optional<Food> findById(String id, Set<String> selectedFields)
    {
        Criteria criteria = new Criteria("id").is(id);

        Query q = Query.query(criteria);
        q.fields().include(selectedFields.toArray(String[]::new));

        return mongoTemplate.find(q, Food.class).stream().findFirst();
    }
}
