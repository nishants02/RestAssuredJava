package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

    //Add function
    @Test //With @Test this will become a TestNG test
    public void demo(){

        Response response = RestAssured.get("https://dummyjson.com/users");

        int statusCode = response.getStatusCode();

        System.out.println("The status code is: " + response.getStatusCode());
        System.out.println("The response time is " + response.getTime() + " ms");
        System.out.println("The response body is \n" + response.getBody().asString());
        System.out.println("The status line is " + response.getStatusLine());
        System.out.println("The headers are " + response.getHeader("content-type"));

        Assert.assertEquals(statusCode, 200);

        /*
        if(statusCode == 200){
            System.out.println("Status code is 200");
        */
        }

        @Test
        public void test2(){

            baseURI = "https://dummyjson.com"; //https://bhagavadgita.com/api https://dummyjson.com

                    given().get("/products/categories"). //https://bhagavadgita.com/bhagavad-gita-quotes

                    then().statusCode(200);

        }

    }