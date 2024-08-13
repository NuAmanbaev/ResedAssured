package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

import java.lang.module.Configuration;


public class LoginSteps {

    LoginPage loginPage = new LoginPage();



    @Given("user is on login page")
    public void user_is_on_login_page() {
      Driver.getDriver().get(Config.getProperty("saucedemo"));



    }
    @When("user provides a valid email")
    public void user_provides_a_valid() {
        loginPage.email.sendKeys(Config.getProperty("email"));

    }
    @When("user provides valid password")
    public void user_provides_valid() {
        loginPage.password.sendKeys(Config.getProperty("password"));

    }
    @Then("user cliks on log in button")
    public void user_cliks_on_log_in_button() {
        loginPage.loginButton.click();

    }
    @Then("verify user is loged in")
    public void verify_user_is_loged_in() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedUrl);


    }

}
