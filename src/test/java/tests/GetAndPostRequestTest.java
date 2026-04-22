package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class GetAndPostRequestTest {

    @Test
    public void testGET(){

        //https://json-placeholder.mock.beeceptor.com (get, post)
        //https://app.beeceptor.com/mock-server/dummy-json (get)

        baseURI = "https://json-placeholder.mock.beeceptor.com";

        given().get("/posts")

                .then().statusCode(200)
                    .body("[0].id", equalTo(1))
                    .body("[1].comment_count", equalTo(12))
                    .body("title", hasItem("Cybersecurity Best Practices"))
                    .body("userId", hasItems(1, 4));

    }

    @Test
    public void testPOST(){

        /*
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("username", "NPS");
        map.put("password", "NewPass");

        System.out.println(map);
        */

        JSONObject request = new JSONObject();

        request.put("username", "NPS");
        request.put("password", "NewPass");

//        System.out.println(request.toString());

        baseURI = "https://json-placeholder.mock.beeceptor.com";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON). //Content sending is of type JSON
                accept(ContentType.JSON). //Response accepted will be of type JSON
                body(request.toString()).
                when().
                    post("/login").
                then().
                    statusCode(200).log().all(); //Status code is 200

    }

}
