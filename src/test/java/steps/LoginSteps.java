package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {
    @Given("the user navigate to the website")
    public void the_user_navigate_to_the_website() {
          openBrowserAndLaunchApplication();
    }
    @When("user enters the username and password")
    public void user_enters_the_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText("Admin",usernameField);
        sendText("Hum@nhrm123",passwordField);
    }
    @When("clicks on login Button")
    public void clicks_on_login_button() {
        WebElement loginButton =  driver.findElement(By.id("btnLogin"));
//         click(loginButton);
        jsClick(loginButton);
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        System.out.println(driver.getTitle());

    }

    @When("user enters the incorrect username and password")
    public void user_enters_the_incorrect_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText("Admin",usernameField);
        sendText("Hum@n",passwordField);
    }
    @Then("the user is not logged")
    public void the_user_is_not_logged() {
        System.out.println(driver.getTitle());
    }

}
