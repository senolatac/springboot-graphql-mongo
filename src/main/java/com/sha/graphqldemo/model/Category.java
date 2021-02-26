package com.sha.graphqldemo.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sa
 * @date 26.02.2021
 * @time 12:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category
{
    @GraphQLQuery(name = "name", description = "A category's name")
    private String name;
}
