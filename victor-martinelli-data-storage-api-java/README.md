# Coding Exercise: Data Storage API

Implement a small HTTP service to store objects organized by repository.
Clients of this service should be able to GET, PUT, and DELETE objects.

## Expectations

We ask you complete this exercise, so you have an opportunity to build a service in your own time rather than an in-person interview, coding on a whiteboard.

We expect that this exercise will take around 2 hours to complete. We value your time and don't want to set unreasonable expectations on how long you should work on this exercise. However, you will have access to the repo for 5 hours. Mostly we extend the time to 5 hours just in case you are unexpectedly interrupted or prefer to break up the time over 5 hours. If you choose to, you may take more than 2 hours as we are not tracking the time spent on it but will evaluate the content of the PR.

## General Requirements

- The service should de-duplicate data objects by repository.
- The included tests should pass and not be modified. Adding additional tests is encouraged.
- The service must implement the API as described below.
- The data can be persisted in memory, on disk, or wherever else you'd like.
- Do not include any extra dependencies.

## Suggestions

- Your code will be read by humans, so organize it sensibly.
- Use this repository to store your work. Committing just the final solution is _ok_, but we'd love to see your incremental progress. We suggest taking a look at [GitHub flow](https://guides.github.com/introduction/flow/) to structure your commits.
- [Submit a pull request](https://help.github.com/articles/creating-a-pull-request/) once you are happy with your work.
- Treat this pull request as if you’re at work submitting it to your colleagues, or to an open source project. The body of the pull request can be used to describe your reasoning and any assumptions or tradeoffs in your implementation.
- Java is an object-oriented programming language. Consider where:
  - Functionality should be abstracted away from one layer to the next
  - Functionality should be grouped together or kept separate
  - Domain ideas should be represented as objects
- Remember that this is a web application, and multiple requests could come in at the same time. Be sure to plan for this.

## API

### Upload an Object

```
PUT /data/{repository}
{binary object data}
```

#### Response

```
Status: 201 Created
{
  "oid": "2845f5a412dbdfacf95193f296dd0f5b2a16920da5a7ffa4c5832f223b03de96",
  "size": 1234
}
```

### Download an Object

```
GET /data/{repository}/{objectID}
```

#### Response

```
Status: 200 OK
{binary object data}
```

Objects that are not on the server will return a `404 Not Found`.

### Delete an Object

```
DELETE /data/{repository}/{objectID}
```

#### Response

```
Status: 200 OK
```

## Getting started and Testing

- Make sure you have the JDK 8 or above
- Use your favorite editor or IDE to load up the project
  - We recommend [Visual Studio Code](https://code.visualstudio.com/docs/java/java-tutorial) or [IntelliJ Community](https://www.jetbrains.com/idea/download/). VS Code is MUCH faster to get up and running.
- Compile by running `gradlew clean build`
- Run the tests using `gradlew test`. They'll fail! You're responsible for getting them to pass with your solution.
  - Your editor or IDE may have additional features to run and debug tests. You'll find those useful!
- You can also start up a "real" instance of the application by using `gradlew bootRun`.
- If you're unfamiliar with the concept, we suggest a quick read of [Spring Dependency Injection](https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-spring-beans-and-dependency-injection.html)
