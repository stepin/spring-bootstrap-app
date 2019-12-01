Spring Template App
===================

Links
-----

1. http://localhost:8080/swagger-ui.html
1. http://localhost:8080/v2/api-docs
1. http://localhost:8080/example
1. http://localhost:8080/example/app_config
1. http://localhost:8080/example/git_branch
1. http://localhost:8080/actuator/prometheus
1. http://localhost:8080/actuator/health
1. http://localhost:8080/graphiql


GraphQL examples
----------------

h3.  query

    {
      example
    }

h3. mutate

    mutation {
      createExample(exampleDate: "2016-08-16")
    }
