package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SubscriptionPage;

public class StepDefinitions {
    private SubscriptionPage pageHandle;

    @Given("customer navigates to {string} subscription page")
    public void customerNavigatesToSubscriptionPage(String country) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        pageHandle = new SubscriptionPage(driver);
        pageHandle.navigateToSubscriptionsPage(country);
    }

    @When("verify package {string}")
    public void verifyPackage(String name) {
        pageHandle.verifyPackageName(name);
    }

    @Then("verify package {string} {string}")
    public void verifyPackage(String name, String price) {
        pageHandle.verifyPackagePrice(name, price);
    }

    @And("verify package {string} currency is {string}")
    public void verifyPackageCurrencyIs(String name, String currency) {
        pageHandle.verifyPackageCurrencyIs(name, currency);
    }
}
