package First;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestsOnLocalAPI {
    @Test
    public void get(){
        given()
                .when()
                .get("http://localhost:3000/Users")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void Post() {
        //Map<String,Object>map=new HashMap<String,Object>();
        JSONObject request = new JSONObject();
        request.put("Firstname", "Thomas");
        request.put("Lastname", "Edison");
        request.put("SubjectId", 1);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)

                .body(request.toJSONString())
                .when()
                .post("http://localhost:3000/Users")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void put() {
        JSONObject request = new JSONObject();
        request.put("Firstname", "Albert");
        request.put("Lastname", "ram");
        request.put("SubjectId", 1);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)

                .body(request.toJSONString())
                .when()
                .put("http://localhost:3000/Users/1")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void patch() {
        JSONObject request = new JSONObject();

        request.put("Lastname", "Doe");


        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)

                .body(request.toJSONString())
                .when()
                .patch("http://localhost:3000/Users/1")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void delete() {
       given()
               .when()
                .delete("http://localhost:3000/Users/4")
                .then()
                .statusCode(200)
                .log().all();
    }
    }
