package com.ql.UserTodoManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserTodoManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTodoManagerApplication.class, args);
	}

}

//      todo-app/
//		│── src/main/java/com/example/todo/
//		│   ├── controller/
//		│   │     ├── UserController.java
//│     │         ├── TodoController.java
//│     │
//		│   ├── model/
//		│   │     ├── User.java
//│     │         ├── Todo.java
//│     │
//		│   ├── repository/
//		│   │     ├── UserRepository.java
//│     │         ├── TodoRepository.java
//│     │
//		│   ├── service/
//		│   │     ├── UserService.java
//│     │         ├── TodoService.java
//│     │
//		│   ├── exception/
//		│   │   ├── GlobalExceptionHandler.java

//		│   ├── TodoApplication.java (Main class)
//│
//		├── src/main/resources/
//		│   ├── application.properties
//│
//		├── pom.xml (Maven dependencies)
//
