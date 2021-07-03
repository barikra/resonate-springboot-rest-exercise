Project:resonate-springboot-rest-exercise
This is a spring boot REST api exercise.

Tested on:
Java 1.8
Gradle: gradle-7.1.1

#BUILD
gradle build

#Run
gradlew bootRun

#Test
Unit tested
and Postman attached in root file name: resonate_test.postman_collection.json
API's endpoints can be accessed:
1.Create a new book:
POST: localhost:8080/api/v1/book
JSON:
{
	"rating": "5",
    "date": "2021-08-03T01:14:39.302+00:00",
    "author": "Best Author",
    "title": "Test book",
    "isbn": "as223fedfd"
}
2Get a book with ISIN: as223fedfd
GET: localhost:8080/api/v1/book/as223fedfd

3. Get all available books:
GET: localhost:8080/api/v1/books

#Limitaion
No persistent storage implemented.

