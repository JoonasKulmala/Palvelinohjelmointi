# 2. Model & View

- [2. Model & View](#2-model--view)
  - [1. Hello Thymeleaf](#1-hello-thymeleaf)
  - [2. Handling Lists](#2-handling-lists)
  - [3. Friend List](#3-friend-list)
  - [4. Bookstore](#4-bookstore)

Run the java application file [PalvelinohjelmointiApplication.java](src/main/java/com/example/Palvelinohjelmointi/PalvelinohjelmointiApplication.java) and open browser at `localhost:8080`

## 1. Hello Thymeleaf

- [HelloController.java](src/main/java/com/example/Palvelinohjelmointi/web/HelloController.java)
- [hello.html](src/main/resources/templates/hello.html)

`/hello?name=${name}&age=${age}`

If age is >= 18: *Welcome ${name}!*

If age is < 18: *You are too young!*

## 2. Handling Lists

- [Student.java](src/main/java/com/example/Palvelinohjelmointi/domain/Student.java)
- [StudentController.java](src/main/java/com/example/Palvelinohjelmointi/web/StudentController.java)
- [studentlist.html](src/main/resources/templates/studentlist.html)

`/studentlist`

![exercise2](Resources/exercise2.png)

## 3. Friend List

## 4. Bookstore