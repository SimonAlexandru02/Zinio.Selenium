package cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class StepDefinitions {
    private WebDriver driver;

    private final String BASE_URL = "https://www.zinio.com/";

}

    @Given("^I go to the login page$")
    public void go_to_login_page() {
        driver.get(BASE_URL);
    }

    @When("I login as a valid user")
    public void login_as_valid_user() {
        login("existing_user", "CorrectPassword");
    }

    @When("I login as an invalid user")
    public void login_as_invalid_user() {
        login("unexisting_user", "CorrectPassword");
    }

    @Then("The item list is not displayed")
    public void item_list_is_not_diplayed() {
        Assert.assertEquals(driver.findElements(By.id("inventory_container")).size(), 0);
    }

    @Then("The item list is displayed")
    public void item_list_is_diplayed() {
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
    }
}