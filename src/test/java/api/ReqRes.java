package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ReqRes {
    public static void main(String[] args) {
        String url = "https://reqres.in/api/users/7";

        Response response = RestAssured.get(url);
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());

        String email = response.jsonPath().get("data.email").toString();
        System.out.println(email);
        String firstName = response.jsonPath().get("data.first_name").toString();
        String lastName = response.jsonPath().get("data.last_name").toString();
        String text = response.jsonPath().get("support.text").toString();
        String avatar = response.jsonPath().get("data.avatar").toString();
        Assert.assertTrue(avatar.endsWith(".jpg"));
        Assert.assertTrue(email.endsWith("@reqres.in"));
        Assert.assertFalse(text.isEmpty());
        Assert.assertEquals(200, response.getStatusCode());

        String baseUri = "https://backend.cashwise.us";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MjU3NTI5MzAsImlhdCI6MTcyMzE2MDkzMCwidXNlcm5hbWUiOiJhbWFuYmFldjYyQGdtYWlsLmNvbSJ9.lfrYuoRQCTeH7Y_zVqy49R8FISp_YTw4XoDa7Adj9QnDJAri8NGLzN2DsSos0xON3UfHMgYrw8cIR6RcxDVpbA";
        RestAssured
                .given()
                .auth()
                .oauth2(token)
                .baseUri(baseUri)
                .when()
                .get("/api/myaccount/sellers")
                .then()
                .statusCode(200);




    }
}
