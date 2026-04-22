package tests;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutPatchDeleteRequestTest {

    @Test
    public void putRequest(){

//        Response resposne = RestAssured.get("https://razorpay-mock-api.mock.beeceptor.com/v1/customers");
//        baseURI = "https://razorpay-mock-api.mock.beeceptor.com";
//        given().
//                get("v1/customers");
//        System.out.println(resposne);

        JSONObject request = new JSONObject();
       /*
            cust_LQPdeJqQeKQrJM
            "name": "Saurav Kumar",
            "email": "saurav.kumar@example.com",
            "contact": "9876543210"
        */

        request.put("name", "LSM");
        request.put("email", "lsm@gmail.com");
        request.put("contact", "90827579987");

        baseURI = "https://json-placeholder.mock.beeceptor.com";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON). //Content sending is of type JSON
                accept(ContentType.JSON). //Response accepted will be of type JSON
                body(request.toString()).

                when().
                put("/v1/customers/cust_LQPdeJqQeKQrJM").

                then().
                statusCode(200).log().all(); //Status code is 200

    }

    @Test
    public void patchRequest(){

        baseURI = "https://razorpay-mock-api.mock.beeceptor.com";

        given().get("/v1/orders/order_EKzX2WiEWbMxmx");

    }

}
