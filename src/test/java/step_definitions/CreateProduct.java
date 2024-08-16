package step_definitions;

import com.github.javafaker.Faker;
import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.CashWiseToken;
import utilities.Config;

public class CreateProduct {

    RequestBody body = new RequestBody();
    String token = CashWiseToken.getToken();
    String baseUrl = Config.getProperty("baseCashwiseUrl");
    Faker faker = new Faker();


    @Given("user provides catogories name {string}")
    public void user_provides_catogories_name(String categoryName) {
        String category_title = categoryName;
        body.setCategory_title(category_title);


    }
    @When("I provide valid authorization new  {string}")
    public void i_provide_valid_authorization_new(String token) {
       Config.getProperty("cashwiseToken");
    }

    @Given("user provides categories description {string}")
    public void user_provides_categories_description(String categoryDescription) {
        String category_description = categoryDescription;
        body.setCategory_description(category_description);

    }



    @When("user provides true flag")
    public void user_provides_true_flag() {
       body.setFlag(true);
    }

    @Then("user hits endpoint {string}")
    public void user_hits_endpoint(String endPoint) {
        Response response = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(body)
                .post(baseUrl  + endPoint);
            response.prettyPrint();
        System.out.println( "Status Code " +   response.statusCode());



    }


//
    @Then("user provides product title")
    public void user_provides_product_title() {
        String product_title = faker.name().title();
        body.setProduct_title(product_title);


    }
    @Then("user provides price")
    public void user_provides_price() {
        Integer product_price = 200;
        body.setProduct_price(product_price);

    }
    @Then("user provides service type id")
    public void user_provides_service_type_id() {
        Integer service_type_id = 1;
        body.setService_type_id(service_type_id);


    }
    @Then("user provides category id")
    public void user_provides_category_id() {
        Integer category_id = 1722;
        body.setCategory_id(category_id);

    }
    @Then("useur provides product description")
    public void useur_provides_product_description() {
        String product_description = faker.name().firstName();
        body.setProduct_description(product_description);

    }
    @Then("user provides date of payment")
    public void user_provides_date_of_payment() {
        String date_of_payment = "2024-08-15";
        body.setDate_of_payment(date_of_payment);

    }
    @Then("user provides remind before date")
    public void user_provides_remind_before_date() {
        Integer remind_before_day = 2;
        body.setRemind_before_day(remind_before_day);

    }
    @Then("user provides do remind every month {string}")
    public void user_provides_do_remind_every_month(String remindBefore) {
        String do_remind_every_month =  remindBefore;
        body.setDo_remind_every_month(remindBefore);

    }

    @Then("user hits endpoint with {string}")
    public void user_hits_endpoint_with(String endpoint1) {
        Response response = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON)
                .body(body)
                .post(baseUrl + endpoint1);


        response.prettyPrint();
        System.out.println(response.statusCode());



    }




}
