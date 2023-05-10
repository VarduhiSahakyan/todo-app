# todo-app

Test Task

A simple todo list restful api example built with Java Spring framework

Ability to view todo list, add new todo, update priority and status, delete old one.

Requirements

1. Lise mysql db engine to create table for todos with fields: id, name, priority and status.

2. Use maven to create the project.

3. Create controller with @RestController to provide crud operations for todos.

4. Create required entity, repository, service with implementation to work with todo objects.

5. Create public repo in git, push all codes into master branch and provide the link.

REST API

GET /todos/todos/{id}

POST /todos

PUT /todos/{id}

DELETE /todos/{id}



Sample Requests for use the API and provide a quick reference for testing different scenarios.


Get all Todos
URL: localhost:7777/todos
Method: GET

Response:
JSON array of To-Do objects:
[  {    "id": 1,   
"name": "Buy groceries",    
"priority": "HIGH",    
"status": "OPEN"  }, 
{    "id": 2,    
"name": "Finish project",    
"priority": "MEDIUM",    
"status": "IN_PROGRESS"  },  
...]


Get Todo 
URL: http://localhost:7777/todos/{id}
Method: GET
Response:
JSON object containing the details of the Todo.

Add a new Todo
URL: localhost:7777/todos
Method: POST

Request Body
{
  "name": "Buy groceries",
  "priority": "HIGH",
  "status": "OPEN"
}

Response
Status Code: 201 CREATED

Update Todo
URL localhost:7777/todos/{id}
Method: PUT

Request Body

{
    "priority": "HIGH",
    "status": "OPEN"
}

Response
JSON object that represents the updated ToDo object.


Delete todo.
URL localhost:7777/todos/{id}
Method: DELETE

Response
Status Code 204 NO CONTENT.
