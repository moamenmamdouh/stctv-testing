package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefinitions {

    private WebDriver driver;
    private String baseURL;
    @Given("customer navigates to STCtv subscription page")
    public void customerNavigatesToSTCtvSubscriptionPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://subscribe.stctv.com/";
    }

    @When("customer navigates to {string} subscription page")
    public void customerNavigatesToSubscriptionPage(String country) {
        String countryURL;
        switch (country) {
            case "KSA" -> {
                countryURL = "sa-en";
                driver.get(baseURL+countryURL);
            }
            case "Bahrain" -> {
                countryURL = "bh-en";
                driver.get(baseURL+countryURL);
            }
            case "Kuwait" -> {
                countryURL = "kw-en";
                driver.get(baseURL+countryURL);
            }
        }
    }

    @Then("verify package {string}")
    public void verifyPackage(String name) {
        String id = "name-"+name;
        String packageName = driver.findElement(By.id(id)).getText();
        Assert.assertTrue(packageName.equalsIgnoreCase(name));
    }

    @And("verify package {string} {string}")
    public void verifyPackage(String name, String price) {
        String cssSelector = "#currency-"+name+" > b";
        Assert.assertEquals(driver.findElement(By.cssSelector(cssSelector)).getText(),price);
    }

    @And("verify package {string} currency is {string}")
    public void verifyPackageCurrencyIs(String name, String currency) {
        String cssSelector = "#currency-"+name+" > i";
        Assert.assertTrue(driver.findElement(By.cssSelector(cssSelector)).getText().contains(currency));
        driver.quit();
    }
}
