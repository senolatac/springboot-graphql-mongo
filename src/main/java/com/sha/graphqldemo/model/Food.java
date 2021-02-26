package com.sha.graphqldemo.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sa
 * @date 25.02.2021
 * @time 12:31
 */
@Data
@Document(collection = "foods")
public class Food {

    @Id
    @GraphQLQuery(name = "idX", description = "A food's id")
    private String id;

    @GraphQLQuery(name = "name", description = "A food's name")
    private String name;

    @GraphQLQuery(name = "category", description = "A food's category")
    private Category category;
}
