#### Core Concepts of Spring Security:

1. Authentication
2. Authorization
3. Principal
4. Granted Authority
5. Roles

#### Create a web application:
Add a Controller
    @RestController
    public class HelloWorldController {
        
        @GetMapping("/hello")
        public String sayHello() {
            return "Hello Word";
        }
   
    }
Run the Application (mvn spring-boot:run) on 8080 and access http://localhost:8080/hello

#### Adding spring security to Spring boot project:
Now  Add Spring Security & Spring Security test
	
	<dependency>
	    <groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
	</dependency>
		
    <dependency>
    	<groupId>org.springframework.security</groupId>
    	<artifactId>spring-security-test</artifactId>
    	<scope>test</scope>
    </dependency>	

Now you should see login page, Also you should check in the logs for `Using generated security password:`
userName : user

Now you can add default user , by adding to application.properties

    spring.security.user.name=foo
    spring.security.user.password=fooo