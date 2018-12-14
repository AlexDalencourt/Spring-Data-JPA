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
    * ProductController : method __home__
  * Orders page without using filter
    * OrderController : method __init__
* findById :
  * Sign up for control not existing user
    * LoginController : method __doLogin__
      * Use the property isPresent
* save / saveAll :
  * Stock order in administration page
    * AdministrationController : method __commandStock__
      * Make a save or update on all entries 

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
  * Administration, using AdministrationController
    * Repository : __ProductRepository__ => Count function
```java
int countByNameLike(String pattern);
```
    * Repository : __OrderRepository__ => Between word, OrderBy
```java
List<Order> findAllByDateBetweenOrderByDateDesc(Date dateAfter, Date dateBefore);
```
* Property Expressions
  * Orders page with name filter
    * Repository : __OrderRepository__
```java
List<Order> getAllByOwnerName(String name);
```
  * Administration, using AdministrationController, filter Suppliers for on product
    * Repository : __SupplierRepository__
```java
List<Supplier> findAllByCatalog_Id(Integer productId);
```
* Special parameter handling
  * Orders page options
    * Repository : __OrderRepository__
```java
List<Order> findAll(Sort sorter);
Page<Order> findAll(Pageable paginator);
```