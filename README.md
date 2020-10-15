#Homeserver Project

### Project target
Target of this project is to create a small home server to run on a Raspberry PI.
* **Target features:**
* Database for storing stuff like shopping lists
* Media control for showing photo slideshows and playing radio/music
* GPIO control for smart home functions
* REST Api to connect mobile devices
* Webinterface


### Dependencies / Requirements
* JDK 8
* Maven 3
* MySQL 5.7
* Springboot 2.2.2
* Pi4J 1.2
* Primefaces 8.0

### Running/development instructions:
Build with Maven: mvn clean install or mvn clean package

Run with Maven: mvn spring-boot:run

View in browser: http://localhost:8080/home