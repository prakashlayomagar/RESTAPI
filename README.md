# RESTAPI

Small Spring Boot demo REST API that serves user data from a JSON file.

## Quick Start

Requirements:
- Java 11+ (project uses Java 23 in pom.xml)
- Internet access for Maven to download dependencies

From the project root, build and run with the Maven wrapper:

./mvnw clean package
./mvnw spring-boot:run

Or run the packaged jar:

./mvnw package
java -jar target/RESTAPI-0.0.1-SNAPSHOT.jar

## Data
User data is stored in src/main/resources/data/users.json and is loaded at startup by UserService.

## API
- GET /user?id=<id> — returns a single user JSON object

Example:

curl 'http://localhost:8080/user?id=2'

# Response
{
  id: 2,
  name: JaneSmith,
  age: 28,
  email: jane.smith@example.com
}

## Development notes
- User model is in src/main/java/net/javaguides/springboot/api/model/User.java.
- UserService loads users.json on startup and exposes getUser(Integer id).
- If you want a list endpoint or persistence, I can add it.

--
Generated update: added run instructions and API examples.
