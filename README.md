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

### Using query methods

* Query creation
  * Home page with product filter
    * Repository : __ProductRepository__
```java
List<Product> findAllByName(String name);
```
* Property Expressions
  * Orders page with name filter
    * Repository : __OrderRepository__
```java
List<Order> getAllByOwnerName(String name);
```