package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Before;
import java.time.Duration;

public class ShoppingSteps {

    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized", "--ignore-certificate-errors", "--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    public static WebElement waitUntilFindElement(WebDriver webDriver, By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10), Duration.ofMillis(200));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(webDriver1 -> webDriver1.findElement(by));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println("Unable to find that element: " + by.toString());
        }
        return webDriver.findElement(by);
    }

    @Given("I visit the website {string}")
    public void iVisitTheWebsite(String url) {
        driver.get(url);
    }

    @And("I search for the product {string}")
    public void iSearchForTheCategory(String product) {
        waitUntilFindElement(driver, By.xpath("//input[@type = 'text']")).sendKeys(product);
    }
    @And("I select the first product from the search results")
    public void iSelectTheFirstProductFromTheSearchResults() {
        //waitUntilFindElement(driver, By.xpath("//*[@class='autocomplete-suggestion']/a")).click();
        waitUntilFindElement(driver,By.xpath("//*[@type = 'text']/..//button")).click();
        waitUntilFindElement(driver,By.xpath("//div[@class='showcase-image-container']//a[@title= 'Ürün']")).click();

    }

    @And("I select {int} item from dropdown menu")
    public void iSelectItemFromDropdownMenu(int arg0) {
        WebElement quantityDropdown = waitUntilFindElement(driver, By.id("qty-input"));
        Select selectQuantity = new Select(quantityDropdown);
        selectQuantity.selectByIndex(arg0 - 1);
    }

    @When("I add the selected items to the cart")
    public void iAddTheSelectedItemsToTheCart() {
        WebElement addToCartButton = waitUntilFindElement(driver, By.cssSelector("a.add-to-cart-button[data-selector='add-to-cart']"));
        addToCartButton.click();
    }

    @Then("I should see notification message on the screen")
    public void iShouldSeeNotificationMessageOnTheScreen() {
        boolean notificationMessage = waitUntilFindElement(driver,By.xpath("//*[@class='shopping-information-cart-inside']")).isDisplayed();
        Assert.assertTrue(notificationMessage);
    }

     @Then("I should see {string} message")
    public void iShouldSeeMessage(String expectedMessage) {
        String notificationMessage = waitUntilFindElement(driver,By.xpath("//*[@class='shopping-information-cart-inside']")).getText();
        if(expectedMessage.equals(notificationMessage)) {
            System.out.println("Mesaj doğru");
        }
        else {
            System.out.println("Mesaj yanlış");
            Assert.fail();
        }
    }


    @When("I navigate to the cart page")
    public void iNavigateToThePage() {
        //driver.get("https://testcase.myideasoft.com/sepet");
        WebElement sepetLink = waitUntilFindElement(driver, By.xpath("//a[@href='/sepet' and @title='Sepet']"));
        sepetLink.click();
    }


    @Then("The cart should contain 5 items of the selected product")
    public void theCartShouldContainItemsOfTheSelectedProduct() {
        String quantity =  waitUntilFindElement(driver,By.xpath("//*[@data-selector='qty']")).getAttribute("value");

        if (quantity.equals("5"))
        {
            System.out.println("test passed " +quantity+ " product added to the basket");
        }
        else System.out.println("test failed " +quantity+ " product added to the basket");

        driver.quit();
    }

}
