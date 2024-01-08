
### 2. 
specify the type of name is varchar(255) and the default value is "John Snow"

specify the column name in the table should be "STUDENT_NAME", the length is 50, it can not be null, and the value is allowed to not be unique.
### 3. 
the default column name is first_name and operating_system
### 4. The layers in Springboot application
- Presentation layer: Authentication, JSON Translation
- Business layer: Business Logic, Validation, Authorisation
- Persistence Layer: Storage Logic
- Database: Actual Database

### 5. describe the flow in all the layers
Presentation layer gets the request from the clients and sends the data to the business layer.
The business layer uses the designed business logic to handle the data from presentation layer.
Persistence layer works with business layer to store the related data.
Database layer update the modified data into the database as requested.

### 6. what is application.properties
Application properties are configurable application parameters on an application's behavior.
We define every type of the property in the file.

