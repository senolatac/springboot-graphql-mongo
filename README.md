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
```
{
  foods {
    idX
    name
  }
}
```
