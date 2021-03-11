# CS6221Project_Backend
Backend of Mango Household Management System

Java JDK: 1.8
Framework: Spring Boot

------------(create local mysql server)-----------

The database we use is localhost.
Please proceed following step to initiate the database.

1. Using Xampp or Docker to run the sql serve:
  (i)   The port of sql server is 3306.
  (ii)  The username is "root".
  (iii) The password is my-password.
  Please configure your local server as above; otherwise, the project won't be able to connect to the DB.
  
2. Install sql management application. e.g. MySQL Workbench.

3. Open the sql management application and connect to local sql server.

4. Create a new query, copy the content of MangoMDB_Scheme.sql, paste it into the query, and then execute. File MangoMDB_Scheme.sql is located in ~/src/main/resources/mySQL_query

5. After step 4, there should be a database called "MangoMDB" in the localhost sql server.

6. Create a new query, copy the content of MangoMDB_Data.sql, paste it into the query, and then execute. File MangoMDB_Data.sql is located in ~/src/main/resources/mySQL_query

7. After step 6, there should be tables and data in the "MangoMDB" db.
