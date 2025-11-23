Feign – Quoters Extended Client

This project is a Feign-based client created to consume the API from the Quoters Extended application.
It demonstrates how to use Spring Boot + OpenFeign to perform requests using headers, request parameters, POST bodies and DELETE operations.

🚀 Features

The application sends requests to a locally running Quoters Extended API:

✔️ 1. GET /apiWithHeader

Sends a custom header:
requestId: someID
Logs the list of quotes returned by the server.

✔️ 2. GET /apiWithRequestParam?id=11

Retrieves a single quote by request parameter.
Logs both the response and extracted fields.

✔️ 3. POST /api/quote

Sends a JSON body:
{
  "quote": "some quote"
}
Creates a new quote on the server and logs the full response.

✔️ 4. DELETE /api/quote/{id}

Deletes a quote with ID 12
Logs the status of the remove operation.

📡 Technology Stack

Java 17

Spring Boot 3.x

OpenFeign (Spring Cloud OpenFeign)

SLF4J Logging

Maven/Gradle (depending on your build tool)

🏗️ How to Run

Start the Quoters Extended API (backend).

Run this application with:
mvn spring-boot:run
or
./gradlew bootRun
📁 Project Structure

``` text
src
 └── main
     ├── java
     │    ├── client    → Feign interface
     │    ├── model     → Quote & Value records
     │    ├── runner    → Code performing API calls
     │    └── FeignApplication.java
     └── resources
          └── application.yml

=== Starting API consumption tests ===
-- GET with header --
Response from header call: [ ... ]
-- GET with request param --
Retrieved quote ID=11
-- POST quote --
New quote created: some quote
-- DELETE quote --
Deleted quote with ID=12
=== Tests completed ===
❤️ Author
```
Project created as part of Spring Boot learning path.
Feel free to review, comment, or send suggestions!
