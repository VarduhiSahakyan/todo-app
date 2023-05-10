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
