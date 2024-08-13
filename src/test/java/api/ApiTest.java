package api;

import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.CashWiseToken;
import utilities.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApiTest {

    @Test
    public void testToken(){
        String endPoint = "https://backend.cashwise.us/api/myaccount/auth/login";
        RequestBody requestBody = new RequestBody();

        requestBody.setEmail("amanbaev62@gmail.com");
        requestBody.setPassword("Amanbaev1997");

        Response response =  RestAssured.given().contentType(ContentType.JSON)
                .body(requestBody).post(endPoint);
        int statusCode = response.statusCode();
        Assert.assertEquals(200, statusCode);
       response.prettyPrint();

       String token = response.jsonPath().getString("jwt_token");
        System.out.println(token);

    }

    @Test
    public void getSingleSeller(){
        String url = Config.getProperty("casWiseApi") +  "/api/myaccount/sellers/" + 4631;
        String token = CashWiseToken.getToken();

        Response response = RestAssured.given().auth().oauth2(token).get(url);
        String expecteedEmail =  response.jsonPath().getString("email");
        Assert.assertFalse(expecteedEmail.isEmpty());
        response.prettyPrint();

       Assert.assertTrue(expecteedEmail.endsWith("123"));



    }
    @Test
    public void getAllSellers(){
        String url = Config.getProperty("casWiseApi") + "/api/myaccount/sellers";
        String token = CashWiseToken.getToken();
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 2);


        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        int statusCode = response.statusCode();
        Assert.assertEquals(200, statusCode);
        String email = response.jsonPath().getString("responses[0].email");
        Assert.assertFalse(email.isEmpty());
        response.prettyPrint();
        System.out.println(statusCode);

        //did not work
    }







}
