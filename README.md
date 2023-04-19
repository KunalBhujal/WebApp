# Ecommerce WebApp using SpringBoot
This app deals with adding the user and products to the database. The users are classified as **Customers** and **Admin** which adds role based feature to the project. The customers in the database can view and buy products whereas, admins can add or delete products. The users registered in the database are authenticated using JWT Tokens.This makes secure transactions to the database and project robust.

### Pre-Requisites
* Spring Boot version 3.0 and above.
* Java version 17
* MYSQL database version 8.0.32 and above.
* Postman 

### Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`JDBC_USERNAME:root`

`JDBC_PASSWORD:root@1234`

### How to Run this Project?

1. Import the project from respective directory to the Eclipse IDE or STS.
2. Run the program as Java or SpringBoot application. In the console, the server is started at port 9111 will be displayed.
3. Now open postman, and user the API **RegisterCustomer** to register new user to database. Add required fields to the **Body** in postman and send request.
4. To authenticate the registered user from the database, use **AuthenticateCustomer/Admin** API. This will generate a token in response for that particular user which will be stored in **{{TOKEN}}** and will be accessed by Postman on its own for further API calls.
5. All the APIs can be accessed in a similar manner.
