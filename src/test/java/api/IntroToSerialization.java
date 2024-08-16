package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;

import java.io.ObjectInputFilter;
import java.lang.module.Configuration;
import java.sql.Driver;

public class IntroToSerialization {
    public static void main(String[] args) throws JsonProcessingException {



        String token = utilities.Config.getProperty(("cashwiseToken"));
        String baseUrl = Config.getProperty("baseCashwiseUrl");
        RequestBody body = new RequestBody();
        String nameTag = "ITwwwasdwwww";
        String description = "Data compaasdnywwwwwww";
        body.setName_tag(nameTag);
        body.setDescription(description);

        Response response = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(body)
                .post(baseUrl +"/api/myaccount/tags");
        System.out.println(response.statusCode());


        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(customResponse.getId());
        response.prettyPrint();




        //create category







    }
}
