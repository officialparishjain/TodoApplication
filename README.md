# Project Name
Todo Application

# Frameworks and Language Used
**Spring Boot** 2.1.0
**Java** 17.0
**Maven** 3.8.1

# Data Flow
The following functions are used in the data flow of this project:

_**Models:**_

This is a Todo class in the TodoApplication model package. It represents a todo item and includes the following attributes:

id: A unique identifier for the todo.
todoName: The name or description of the todo.
todoStatus: The status of the todo, represented as a Boolean value indicating whether it is completed or not.
The class includes a constructor to initialize the attributes, as well as getter and setter methods for each attribute. The JsonProperty annotation is used to specify the mapping of the "todoname" property when serializing or deserializing JSON.

_**Controller:**_ 

This is a TodoController class in a TodoApplication. It handles HTTP requests related to managing todos. The controller is responsible for retrieving todos, adding new todos, getting a specific todo by ID, deleting a todo by ID, and updating the status of a todo by ID.

The controller uses TodoService, which is autowired for dependency injection. It includes the following request mappings:

GET /getAllTodos: Retrieves all todos in the list.
GET /getAllTodoByStatus: Retrieves todos based on the provided status parameter.
POST /addTodo: Adds a new todo by accepting a Todo object in the request body.
GET /getTodoById/{id}: Retrieves a specific todo by ID.
DELETE /deleteById/{id}: Deletes a todo by ID.
PUT /updateTodoById/{id}/{status}: Updates the status of a todo by ID, based on the provided status parameter.
The controller returns the appropriate response based on the outcome of each operation..



_**Services**:_ 

his is a TodoService class in the TodoApplication service package. It provides functionality to interact with todos by calling methods from the TodoRepository.

The service class is annotated with @Service to indicate that it is a service component in the application.

The class includes the following methods:

getAllTodosInMyList(): Retrieves all todos from the repository by calling getAllTodos() method from TodoRepository.

addMyTodo(): Adds a new todo to the repository by calling the save() method from TodoRepository. Returns a success message if the insertion is successful, otherwise returns a failure message.

getTodoBasedOnId(): Retrieves a specific todo based on the provided ID. It retrieves all todos from the repository and iterates over them to find the matching todo. Returns the todo if found, otherwise returns null.

deleteTodoById(): Deletes a todo with the specified ID. It retrieves all todos from the repository, searches for the todo with the given ID, and removes it if found. Returns a success message if the todo is deleted, otherwise returns a message indicating that the ID was not found.

updateTodoStatusById(): Updates the status of a todo with the specified ID. It calls the updateTodo() method from TodoRepository and passes the ID and the parsed status value. Returns a success message if the update is successful, otherwise returns a failure message.

getAllTodoByUserStatus(): Retrieves todos based on the provided status. It retrieves all todos from the repository and filters them based on the status. Returns a list of todos that match the status.

The service class autowires the TodoRepository for dependency injection.


_**Repository**:_ 

This is a TodoRepository class in the TodoApplication repository package. It manages the persistence and retrieval of todos.

The repository class is annotated with @Repository to indicate that it is a repository component in the application.

The class includes the following methods:

save(): Saves a todo to the repository by adding it to the todoList. Always returns true to indicate a successful save operation.

getAllTodos(): Retrieves all todos from the repository by returning the todoList.

remove(): Removes a todo from the repository by removing it from the todoList. Always returns true to indicate a successful removal operation.

updateTodo(): Updates the status of a todo in the repository. It searches for the todo with the specified ID in the todoList, removes it, changes its status, and adds it back to the todoList. Returns true if the update is successful, otherwise returns false.

# Database Structure Used
I have use ArrayList as DataBase

# Project Summary
In this project i have create different endpoints like and used differet vaalidation for the end ponits



