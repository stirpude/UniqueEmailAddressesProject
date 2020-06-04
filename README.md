# UniqueEmailAddressesProject

Spring Boot Application web service that accepts http requests and returns responses for checking the unique email addresses.

The input request is sent using postman in the body in following format:

{
     "emails": "test.email@gmail.com,test.email+spam@gmail.com,testemail@gmail.com"
}

Request POST URL : http://localhost:8080/checkemail


