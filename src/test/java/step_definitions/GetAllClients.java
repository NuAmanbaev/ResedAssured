package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetAllClients {



    @Given("user hits base url {string}")
    public void user_hits_base_url(String baseUrl) {
//        Response response =
//                RestAssured
////                        .given()
//                        .baseUri(baseUrl)


    }
    @Then("user validates that status code is {int}")
    public void user_validates_that_status_code_is(Integer int1) {

    }
    @Then("user validates that list is not empty")
    public void user_validates_that_list_is_not_empty() {

    }


}
