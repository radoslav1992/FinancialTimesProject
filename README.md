# Access & Identity Interview Task 01

## FT Users and Licenses application

The aim of this task is to build a Spring Boot RESTFull application, which would allow 
registration of FT readers and allow them to read specific content. 
The provided application is operational with a minimum configuration and endpoints. 
The current goal is to extend this application resulting into fully operational app
adhering to Restfull principals and best programming practices.

### Domain Object Model
 - User - holds information about user personal and professional data
 - Licence - holds info about the contract details and FT products which FT user has subscribed for.
 - Seat -  models many-to-many relationship between Licence and User.
   Usually one License can have 0/many Users seats attached to it.
   Respectively one user could hold a seat in 0/many Licenses 

### Prerequisites
In order to compile and run the app you have to complete the following steps:
 
- Make a running instance of MongoDB could be local, docker or cloud service.
   Default config would search for host `localhost:27017`; Create a new database : `ft` 
- Create a collection for each file under `mongodb` folder and import its content. 
  The name of each collection should be the same as name of the respective file without a suffix 
  e.g. `users, licences,seats`
- Provide JDK 11, Lombok and maven 3.5.x
- Compile and run application `mvn clean install`, `java -jar target/task01-0.0.1-SNAPSHOT.jar`
- Check GET endpoints e.g. `curl http://localhost:8080/users`, `curl http://localhost:8080/licences`

Make sure the app is up and running before you proced with new development.

### Task objectives
In the final solution we would like to see addressed the following concerns:

- There are many **TODO**s across the all codebase which aim to solve a certain issue, 
   all of them should be resolved.
- The current app is not secured at all, the webservice must have at least some **basic security**.
- The app/microservice itself is not developed as per books, try to identify and fix what is wrong/missing 
  in the current solution in terms of architecture design, monitoring, logging, external configuration and continues integration
- Add **Swagger** API documentation for all API endpoints, it should be accessible on [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui/)
- Try to containerize the app and make it runnable inside a docker
- _Optional_: Deploy application on some public service, so it's endpoints could be accessed from anywhere preferably AWS/EC2 instance you can use Free Tier
- _Optional_: Deploy 2-3 instances of the app and put Load Balancer in front of them to spread the traffic across all available instances --
   you can use the AWS Free Tier to achieve that goal.
- _Optional_: Deploy the service on some kubernetes cluster of your own e.g. minikube or some cluster on EC2 instance(s) installed by _kubeadm_, 
provide the respective k8s deployment manifests as part of your solution