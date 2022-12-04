# Zara Prices by Domingo Pérez Guerrero

### Stack technology 
* Java 17
* Spring Framework
* H2
* Hexagonal Architecture

### Application's architecture:
We have 4 modules (application, domain, infrastructure, objectmother) inside de project name: <u>zara-prices-hexagonal</u>.
The main class to run app is ZaraPricesApplication.

### Design decisions:
I have decided to use objectmothers as a best practice to run a battery of parameterized tests,
receiving the input and the output I want to test. 
To test this I used MvcMock.

I have also created a directory called postman with the corresponding collections and environment.
In a complementary way I have implemented the tests in the postman test section.

## To run application
First build with:
```
$mvn clean install
```
Then run it with:
```
mvn spring-boot:run
or
java -jar target/zara-1.0.0-SNAPSHOT.jar  
```
or use your preferred IDE to run it.

## To run test
First build with:
```
$mvn clean install
```
Then run it with:
```
$mvn test
```

#### GitHub: https://github.com/p4pupro
