package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IntroToApi {
    public static void main(String[] args) {

        String baseUri = "https://backend.cashwise.us";
        Response response1 = RestAssured.get(baseUri);
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE" +
                "3MjU3NTI5MzAsImlhdCI6MTcyMzE2MDkzMCwidXNlcm5hbWUiOiJhbWFuYmF" +
                "ldjYyQGdtYWlsLmNvbSJ9.lfrYuoRQCTeH7Y_zVqy49R8FISp_YTw4XoDa7Adj9QnDJAri8N" +
                "GLzN2DsSos0xON3UfHMgYrw8cIR6RcxDVpbA";
        RestAssured
                .given()
                .auth()
                .oauth2(token)
                .baseUri(baseUri)
                .when()
                .get("/api/myaccount/sellers/all")
                .then()
                .statusCode(200);


        RestAssured
                .given()
                .auth()
                .oauth2(token)
                .baseUri(baseUri)
                .and()
                .queryParam("isArchived" , false)
                .queryParam("page",1)
                .queryParam("size",2)
                .when()
                .get("/api/myaccount/sellers")
                .then()
                .statusCode(200);

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size",2);
        Response response = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .params(params)
                .get(baseUri + "/api/myaccount/sellers" );

        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
       Assert.assertEquals(200, response.getStatusCode());






        String sellerID = response.jsonPath().get("responses.seller_id[0]").toString();
        Response response2 = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .baseUri(baseUri)
                .and()
                .get("/api/myaccount/sellers/" + sellerID);

        System.out.println(sellerID);
        System.out.println(response2.prettyPrint());




    }





}
