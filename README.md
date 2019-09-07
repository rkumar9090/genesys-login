# genesys-login

#### To validate a user with login operation and to perform crud operation on user entity.
 

## Technical Stack:

#### language: Java 8

#### Framework: Spring-boot,JPA

#### Database: MySQL

#### Build Tool: Maven

## Build 

Unzip the attached source code(genesys-login.zip)

navigate to home directory 

run mvn clean install

## Run

Execute genesys_ddl.sql file on local MySQL server 

Navigate to target folder

Run java -jar genesys-login-0.0.1-SNAPSHOT.jar

 

## API 

Notes: Spring bean validation will take care of validating api

## Add User

**Endpoint:** http://localhost:8080/api/user

**Method:** POST

**Content-type:** application/json

**Mandatory:** name,password,email

**Body:** 

> {
  "name": "Rajesh",
  "email": "rkumar9090@hotmail.com",
  "password": "Durairaj90"
}

## Response: User added successfully
## Exception 1: Username already exists
Get User List
Endpoint: http://localhost:8080/api/user
Method: GET
Content-type:application/json
Response: [{"userId":5,"userName":"Rfdffdsf","password":"Durairaj90","email":"rk90@hotmail.com","lastlogin":"2019-08-27T18:30:00.000+0000"},{"userId":6,"userName":"Rf","password":"Durairaj90","email":"rkumar9090@hotmail","lastlogin":null}]
## Get User By ID
Endpoint: http://localhost:8080/api/user/{id}
Method: GET
Content-type:application/json
Mandatory:ID
Response: {"userId":5,"userName":"Rfdffdsf","password":"Durairaj90","email":"rk90@hotmail.com","lastlogin":"2019-08-27T18:30:00.000+0000"}
Exception 1: User not exists
## Update User
Endpoint: http://localhost:8080/api/user
Method: PUT
Content-type:application/json
Mandatory:name,password,email,id
Body: {"id",3,
  "name": "Rajesh",

  "email": "rkumar9090@hotmail.com",

  "password": "Durairaj90"

}

## Response: User update successfully
## Exception 1: User not exists
## Login

Endpoint: http://localhost:8080/api/login

Method: POST

Content-type:application/json

Mandatory: username,password

Body:
{
"username": "Rfdffdsf",

 "password": "Durairaj90j"

}

## Response: SUCCESS
## Exception 1: Invalid username and password
## Exception 2: Username is not valid