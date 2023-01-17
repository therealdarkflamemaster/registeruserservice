# Introduction

### Userful Links
- H2 DataBase : http://localhost:8080/h2-console/
- Swagger Link : http://localhost:8080/swagger-ui/index.html

### How to use the API
- Create a user

We need to input at least the user's name, the user's brith date and the residence country to create the user in the 
database. We can also input the phone number and the gender, which are not obligatory. 
As only adult French residents are allowed to create an account, so it will return a code 400 if the user is not a french or not an adult.


Link : POST http://localhost:8080/user
- Find a user by its Id

A id is entitled to a user when it's created. 
If it's found, it will be returned which the necessary infos stored in the datebase, like username. 
If not, it will return a http status 404. 


Link : GET http://localhost:8080/user/{id}

### How to build from the source
- Git clone
- Install maven dependencies
- Build and run the project
