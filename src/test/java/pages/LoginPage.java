package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);


    }

    @FindBy(id = "user-name")
    public  WebElement email;
    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement password;
    @FindBy(id = "login-button")
    public WebElement loginButton;



}
