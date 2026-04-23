# SmartCampusAPI

## How to Build and Run
1.Clone this Repository
2.Open the Project in Net Beans
3.Right click on the project and click on Clean and Build
4.Right click the project and click Run
5.The API will be available at http://localhost:8080/SmartCampusAPI/api/v1

## Sample Curl Commands
# Get all Rooms
curl -X GET http://localhost:8080/SmartCampusAPI/api/v1/rooms

# Get all Sensors
curl -X GET http://localhost:8080/SmartCampusAPI/api/v1/sensors

# Get a Specifc Room

curl -X GET http://localhost:8080/SmartCampusAPI/api/v1/rooms/LAB-100

# Filter sensors by type

curl -X GET http://localhost:8080/SmartCampusAPI/api/v1/sensors?type=TEMPERATURE

# Get sensor readings 

curl -X GET http://localhost:8080/SmartCampusAPI/api/v1/sensors/TEMP-022/readings


## Part 1

# Question 1
For every request made, JAX-RS makes a new resource class by default. This results to any data stored will be lost after each request has been made. To help work around this, I created a separate java class, DataStore, which will be shared amongst all requests and holds the data statically. 

# Question 2
HATEOAS stands for HyperMedia as the Engine of the Application State, it means including links inside API for easy navigation of the API. In my discovery endpoint, links of rooms and sensor resources are returned. This is useful as it is made convenient for the clients to just follow the links in the response instead of reading documentation sheets and see what endpoints are available.

## Part 2

# Question 3
When returning a list of rooms, returning only IDs only allows less data to be sent across the network. The client will need to make extra requests to get the details of each room. Returning full rooms objects allows for more data to be sent and allowing for the client to receive everything they need in one go. I did this exactly in my project, choosing to return full room objects so the client has everything they need.

# Question 4
The first time a room has been sent a DELETE request, the room will be deleted and a 200 response will be immediately returned. A 404 response will be returned if the same room has been sent the same DELETE request - the room will no longer exist. The response will change each time so it isnt really idempotent. Having the same DELETE request sent will not interrupt the system.

## Part 3

# Question 5
If the client sends a data in a different format , JAX-RS will immediately reject the request and send a response 415 - Unsupported Media Type error. This is because I used @Consumes(MediaType.APPLICATION_JSON) which will tell JAX-RS to only have JSON accepted. If a different format of the request has been sent, it will be rejected before it reaches my method.

# Question 6
Using @QueryParam for my work is better because it is optional rather than putting the filter in the URL path. My endpoint /api/v1/sensors still works without having the filter. Using a filter will require clients to have a type in the path if they want all sensors. Query parameters also allow multiple filters such as, status=ACTIVE. Query parameters are a standard way to filter collections and path parameters can be used to identify specific resources.

## Part 4

# Question 7
The benefits of using the Sub Resource Locator pattern allows me to split my code into separate classes. Instead of having everything combined in one class, I created SensorResource and SensorReadingResource separately. This helped me maintain my code easily and if any code altercations were needed I was able to easily find the methods for it, improving the consistency to read my code.

## Part 5

# Question 8
HTTP 422 is more semantically accurate than 404 because 404 means that the URL itself has not been found. So the URL may be valid but the roomID inside the request body has not been identified and or does not seem to exist. A 422 means that the data within the request is wrong but the request is initially understood. If a sensor detects that a room does not exist, sending a 422 in return is more appropriate as it helps us identify that the data is wrong rather than having a problem with the URL itself.

# Question 9
The security risks of exposing Java stack traces to external API consumers are revealing internal information of the application. This includes class names,line names, method and variable names. A third party attacker may identify vulnerabilities of the code and plan attacks. Knowing this information was the reason why I created the GlobalExceptionMapper class, if any errors was to unexpectedly occur, it will safely return a 500 error message instead of exposing the full stack trace to the user.

# Question 10
Using JAX-RS filters for logging rather than manually adding Logger.info() statements in every method is better because filters will be automatically applied to every request and response. This saved me a lot of time and helped me maintain and organised code having it to only write the logging code once in my LoggingFilter class instead of having it copied into every single resource method. Having it added manually would have also caused confusion for me as I would have needed to update every single method if I wanted to change how logging works in my application.

