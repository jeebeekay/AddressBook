Address Book
================================
This app lets an user view Address Book details by talking to Pager Duty APIs.

Stack
-----
* This app uses spring boot + java + tomcat on the backend and jquery + bootstrap + javascript + html on the front end.
* The front end communicates with backend via REST APIs.
* This project uses maven for dependency management & build

Build
-----
* In order to build this project, from project home folder run `mvn package`. This command creates jars in $PROJECT_HOME/target directory.

Launch
----- 
* The default port for tomcat is configured as `8081` in `application.properties`.
* Launch the app by running `java -jar target/AddressBook-0.0.1-SNAPSHOT.jar`.
* Visit http://localhost:8081 to start interacting with the app.


