package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubscriptionPage {
    private static final String baseURL = "https://subscribe.stctv.com/";
    private final WebDriver driver;
    public SubscriptionPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToSubscriptionsPage(String country){
        String countryURL;
        switch (country) {
            case "KSA" -> {
                countryURL = "sa-en";
                driver.get(baseURL+ countryURL);
            }
            case "Bahrain" -> {
                countryURL = "bh-en";
                driver.get(baseURL+ countryURL);
            }
            case "Kuwait" -> {
                countryURL = "kw-en";
                driver.get(baseURL+ countryURL);
            }
        }
    }

    public void verifyPackageName(String name) {
        String id = "name-"+name;
        String packageName = driver.findElement(By.id(id)).getText();
        Assert.assertTrue(packageName.equalsIgnoreCase(name));
    }

    public void verifyPackagePrice(String name, String price) {
        String cssSelector = "#currency-"+name+" > b";
        Assert.assertEquals(driver.findElement(By.cssSelector(cssSelector)).getText(),price);
    }

    public void verifyPackageCurrencyIs(String name, String currency) {
        String cssSelector = "#currency-"+name+" > i";
        Assert.assertTrue(driver.findElement(By.cssSelector(cssSelector)).getText().contains(currency));
        driver.quit();
    }

}
