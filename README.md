#### Spring Boot + MongoDB + GraphQL

#### 1) Build Server Side

```
$ cd springboot-graphql-mongo
$ gradlew bootJar
$ gradlew bootRun
```

### Access graphql using following URL

```
http://localhost:8080/gui
```

Normally, graphql effects on request level but in this project, we also optimized data-fetch-level from Database.

Example Queries:

1.Find All foods
```
{
  foods {
    idX
    name
  }
}
```

2.Find food by id

```
{ 
   food(id: "6038a7f3f533275db547fa2f") { 
     name 
   } 
}
```

3.Create a new food

```
mutation {
  saveFood(food: { name: "Pasta" }) {
    id
    isGood
  }
}
```

