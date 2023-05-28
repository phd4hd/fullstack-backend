# Fullstack Example : Backend

To work with a backend without building this,
e.g. to test the frontend, you can use my
[running backend](https://fullstack-backend.ew.r.appspot.com/) 

## Prerequisite

To build this backend you need the following software

- [JDK Development Kit 17.0.7 downloads](https://www.oracle.com/java/technologies/downloads/#java17)
- [IDEA IntelliJ](https://www.jetbrains.com/idea/)
- [Postman](https://www.postman.com/downloads/)
- if you plan to modify this project (to do the exercise) please fork it first

## Setup

- Install JDK 17
- Install IDEA IntelliJ
- Clone the backend repository with IntelliJ
  - Choose 'File -> New -> Project from Version Control'
  - Enter 'https://github.com/phd4hd/fullstack-backend' as URL
  - If asked, you trust this project
- After the project has loaded you must sync to install all missing dependencies
  - Right-Click on project name in Project explorer
  - Choose 'Maven -> Reload project'

## Run

- If there is no green play button to run
  - Open file 'src/main/java/fullstack.example.backend/FullstackApplication'
  - Click on the left green play button at 'public class FullstackApplication'
  - Click 'Run FullstackApplication.main()'
  - If a popup shows that Lombok needs annotation processing
    you can 'Enable annotation processing'
- If your green play button has some problems
  - Click on the dropdown menu and 'Edit Configurations'
  - Below 'Build and run' choose 'java 17 SDK' (even if it is displayed)
  - And also choose 'fullstack.example.backend.FullstackApplication' (even if it is displayed)

## Problems and possible Solutions

- There is a exception showing that Spring Data cannot access the database
  - Open file 'src/main/resources/.env'
    - to access localhost as database it should read

         MONGO_TYPE="mongodb"
         MONGO_CLUSTER="localhost"
         MONGO_DATABASE="fullstack_db"
         MONGO_USERNAME="madmin"
         MONGO_PASSWORD="geheim123"

    - to access your MongoDB Atlas database it should read similiar to

         MONGO_TYPE="mongodb+srv"
         MONGO_CLUSTER="your-cluster-host-name"
         MONGO_DATABASE="fullstack_db"
         MONGO_USERNAME="your-database-username"
         MONGO_PASSWORD="your-database-username-password"

## Testing

Install Postman and skip the login request

### Test 1

- Enter 'localhost:8080' with 'GET' and send
- It should return an error 'Not found' with 'No message available'

### Test 2

- Enter 'localhost:8080/api/v1/books' with 'GET' and send
- It should return alle books in the database

### Test 3

- Enter 'localhost:8080/api/v1/books/0140306765' with 'GET' and send
- It should only return the 'Fantastic Mr. Fox'

### Test 4

- Enter 'localhost:8080/api/v1/reviews' with 'GET' and send
- It could return the complete list of reviews or an empty list

### Test 5

- Enter 'localhost:8080/api/v1/reviews/0140306765' with 'POST'
- Switch to 'Body' and choose 'raw' and 'JSON'
- Enter in the field below

    {
      "isbn10": "0140306765",
      "reviewText": "Some comment"
    }

- Click 'Send'
- It should return a response with some id and the text with 'Some comment'

## Test 6

- Repeat Test 4 after Test 5 and you should get one more result
  (or at least one now)
