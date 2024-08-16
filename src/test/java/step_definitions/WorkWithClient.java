package step_definitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class WorkWithClient {

    RequestSpecification request;
    Response response;
    JSONObject requestBody = new JSONObject();
    String id;




    @When("I provide company name {string}")
    public void i_provide_company_name(String companyName) {



    }
    @When("I provide client name {string}")
    public void i_provide_client_name(String string) {

    }
    @When("I provide email {string}")
    public void i_provide_email(String string) {

    }
    @When("I provide phone number {string}")
    public void i_provide_phone_number(String string) {

    }
    @When("I provide address {string}")
    public void i_provide_address(String string) {

    }
}
