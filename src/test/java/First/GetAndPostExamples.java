package First;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAndPostExamples {

    @Test
    public void testGet()  {

               given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id",equalTo(7))
                       .body("data[1].first_name",equalTo("Lindsay"));

    }


    @Test
 public void testPost(){
        //Map<String,Object>map=new HashMap<String,Object>();
        JSONObject request= new JSONObject();
       request.put("Name", "Ram");
        request.put("Company", "JIGA");

               given()
                  .header("Content-Type","application/json")
                  .contentType(ContentType.JSON)
                   .accept(ContentType.JSON)

                             .body(request.toJSONString())
                        .when()
                             .post("https://reqres.in/api/users")
                        .then()
                              .statusCode(201)
                        .log().all();
        //System.out.println(request.toJSONString());

 }


}



