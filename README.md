This is Institute managemnet project.
CRUD is done through H2 Database  url : http://localhost:8080/h2-console
User ID and password in application.properties 
To the project in Local:
1. pull tyhe code and import it in Intellij IDE
2. Start the Main class

Use Postman for testing

To Register a Institute : POST: localhost:8080/institute/register
Body :
{
    "name": "BIT",
    "location":"ranchi",
    "contact":"9999999999"
}

To Update a institute : PUT : localhost:8080/institute/1
Body :
{
    "name": "BIT",
    "location":"Sindri",
    "contact":"9999999999"
}

To Fech The Institute : GET : localhost:8080/institute/1
