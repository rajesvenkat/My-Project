package First;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutPatchDelete {
    @Test
    public void testput() {
        JSONObject request = new JSONObject();
        request.put("Name", "Ram");
        request.put("Company", "JIGA");


        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
        //System.out.println(request.toJSONString());

    }

    @Test
    public void testpatch() {
        JSONObject request = new JSONObject();
        request.put("Name", "Ram");
        request.put("Company", "JIGA");


        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                     .body(request.toJSONString())
                .when()
                     .patch("https://reqres.in/api/users/2")
                .then()
                     .statusCode(200)
                .log().all();
          //System.out.println(request.toJSONString());
    }
    @Test
    public void testDelete() {
                given()
                  .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                    .statusCode(204)
                .log().all();
                //System.out.println(request.toJSONString());
    }

}
