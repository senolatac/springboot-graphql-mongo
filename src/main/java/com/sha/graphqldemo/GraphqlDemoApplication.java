package com.sha.graphqldemo;

import com.sha.graphqldemo.model.Category;
import com.sha.graphqldemo.model.Food;
import com.sha.graphqldemo.service.FoodService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.stream.Stream;

@EnableMongoRepositories
@SpringBootApplication
public class GraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}

    @Bean
    ApplicationRunner init(FoodService foodService) {
        return args -> {
            Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
                Food food = new Food();
                food.setName(name);
                food.setCategory(new Category("test-category"));
                foodService.saveFood(food);
            });
        };
    }

}
