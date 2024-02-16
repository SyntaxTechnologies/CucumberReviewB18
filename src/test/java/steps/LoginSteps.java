package steps;

import io.cucumber.java.en.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Log;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {
    @Given("the user navigate to the website")
    public void the_user_navigate_to_the_website() {
          openBrowserAndLaunchApplication();
    }
    @When("user enters the username and password")
    public void user_enters_the_username_and_password() {
//        dom configuration
        DOMConfigurator.configure("log4j.xml");
        Log.startOfTestCase("dksfksfsdkmfdk");
        Log.logTheException("sfddsfdsfsfdsfssf");


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



    @When("user enters the username {string} and the password {string}")
    public void user_enters_the_username_and_the_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(username,usernameField);
        sendText(password,passwordField);
    }
    @When("user clicks login Button")
    public void user_clicks_login_button() {
        WebElement loginButton =  driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }
    @Then("the user sees the message {string}")
    public void the_user_sees_the_message(String expectedMessage) {
        String actualMsg = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
        Assert.assertEquals(actualMsg,expectedMessage);
    }



    @When("the user enters the username {string}  and the password {string}")
    public void the_user_enters_the_username_and_the_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(username,usernameField);
        sendText(password,passwordField);
    }

    @Then("the user sees the error message {string}")
    public void the_user_sees_the_error_message(String expectedMessage) {
        String actualMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(actualMsg,expectedMessage);

    }

    @Then("the user enters the username and password and clicks on login then sees the error message")
    public void the_user_enters_the_username_and_password_and_clicks_on_login_then_sees_the_error_message(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> wrongCrdentials = dataTable.asMaps();

        for(Map<String,String>data:wrongCrdentials){

            String username = data.get("username");
            String pass = data.get("password");
            String errormsg = data.get("errorMessage");

            sendText( username,login.usernameField);
            sendText(pass,login.passwordField);
            click(login.loginButton);
            String actualMessage = login.errorMessageLoc.getText();

            Assert.assertEquals(actualMessage,errormsg);
        }

    }


}
