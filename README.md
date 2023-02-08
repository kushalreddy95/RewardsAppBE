# Rewards App - BackEnd

## Setup
- Create a MySQL database with two tables - Customer, Transaction.
- Set the Schema name, Username and password [here]()
- Customer Table consists of two columns: CUSTOMER_NAME Varchar(64), CUSTOMER_ID int
- Transaction Table consists of four columns: CUSTOMER_ID int, TRANSACTION_ID int, TRANSACTION_DATE date, AMOUNT int
- Export the CSV from [here]() to the tables


### Adding Values into Database

- Only transactions values from **01/10/2022 to 31/12/2022** will be displayed by front end app
- If adding new Customer, Add it both in React app [here]() and backend database.

### Running the APP
```
mvn spring-boot:run
```
The above line will instantiate a localhost server at port 8080. Test your API fucntionality by clicking [here](http://localhost:8080/api/1001/rewards)

Now Run the Front End APP.

### Running the Tests
```
mvn test
```


### More Resources

#### Spring Boot JdbcTemplate example with MySQL: Build CRUD App
Build a Spring Boot CRUD Rest API example that uses Spring Data Jdbc to make CRUD Operations with MySQL Database. You'll know:
- How to configure Spring Data to work with MySQL database
- How to define Data Models and Repository interfaces
- Way to create Spring Rest Controller to process HTTP requests
- Way to use Spring Data Jdbc to interact with Database

For instruction, please visit:
> [Spring Boot JdbcTemplate example: CRUD with MySQL database](https://www.bezkoder.com/spring-boot-jdbctemplate-example-mysql/)

Front-end that works well with this Back-end
> [Axios Client](https://www.bezkoder.com/axios-request/)

> [Angular 8 Client](https://www.bezkoder.com/angular-crud-app/) / [Angular 10 Client](https://www.bezkoder.com/angular-10-crud-app/) / [Angular 11 Client](https://www.bezkoder.com/angular-11-crud-app/) / [Angular 12 Client](https://www.bezkoder.com/angular-12-crud-app/)

> [Vue 2 Client](https://www.bezkoder.com/vue-js-crud-app/) / [Vue 3 Client](https://www.bezkoder.com/vue-3-crud/) / [Vuetify Client](https://www.bezkoder.com/vuetify-data-table-example/)

> [React Client](https://www.bezkoder.com/react-crud-web-api/) / [React Redux Client](https://www.bezkoder.com/react-redux-crud-example/)

More Practice:
> [Spring Boot JdbcTemplate, H2 Database: CRUD example](https://www.bezkoder.com/spring-boot-jdbctemplate-crud-example/)

> [Spring Boot, Hibernate, MySQL example](https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/)

> [Spring Boot, Hibernate, PostgreSQL example](https://www.bezkoder.com/spring-boot-postgresql-example/)

> [Spring Boot with MongoDB CRUD example](https://www.bezkoder.com/spring-boot-mongodb-crud/)

> [Spring Boot, Hibernate, Oracle example](https://www.bezkoder.com/spring-boot-hibernate-oracle/)

> [Spring Boot, Hibernate, SQL Server example](https://www.bezkoder.com/spring-boot-sql-server/)

> [Spring Boot File upload example with Multipart File](https://www.bezkoder.com/spring-boot-file-upload/)

> [Spring Boot Pagination & Filter example | Spring JPA, Pageable](https://www.bezkoder.com/spring-boot-pagination-filter-jpa-pageable/)

> [Spring Data JPA Sort/Order by multiple Columns | Spring Boot](https://www.bezkoder.com/spring-data-sort-multiple-columns/)

> [Spring Boot Repository Unit Test with @DataJpaTest](https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/)

> [Deploy Spring Boot App on AWS – Elastic Beanstalk](https://www.bezkoder.com/deploy-spring-boot-aws-eb/)

Security:
> [Spring Boot + Spring Security JWT Authentication & Authorization](https://www.bezkoder.com/spring-boot-jwt-authentication/)

Run both Back-end & Front-end in one place:
> [Integrate Angular with Spring Boot Rest API](https://www.bezkoder.com/integrate-angular-spring-boot/)

> [Integrate React.js with Spring Boot Rest API](https://www.bezkoder.com/integrate-reactjs-spring-boot/)

> [Integrate Vue.js with Spring Boot Rest API](https://www.bezkoder.com/integrate-vue-spring-boot/)

