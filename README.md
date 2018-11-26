# Spring-Data-JPA

## Frameworks

* Spring-Data-JPA
* Hibernate
* Thymeleaf
* MVC

## All queries examples

### Using Standard CrudRepository Library

* findAll :
  * Home page without using filter
    * ProductController : method __Home__
  * Orders page without using filter
    * OrderController : method __init__
* findById :
  * Sign up for control not existing user
    * LoginController : method __doLogin__

### Using query methods

* Query creation
  * Home page with product filter
    * Repository : __ProductRepository__
```java
List<Product> findAllByName(String name);
```
  * Login action, using LoginController
    * Repository : __UserRepository__
```java
User findByLoginAndPassword(String login,String password);
```
* Property Expressions
  * Orders page with name filter
    * Repository : __OrderRepository__
```java
List<Order> getAllByOwnerName(String name);
```