package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchGoogle {
    WebDriver driver;
    @Given("I Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Open website the-internet.herokuapp.com")
    public void openWebsite() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/");
        Thread.sleep(1000);
    }

    @And("Located on the-internet.herokuapp.com")
    public void locatedOnTheInternet() {
        driver.findElement(By.xpath("//a[normalize-space()='Status Codes']")).isDisplayed();
    }

    @When("I click {string}")
    public void iClick(String arg0) {
        driver.findElement(By.xpath("//a[normalize-space()='Status Codes']")).sendKeys(Keys.ENTER);
    }

    @And("Open status code")
    public void openStatusCode() {
        driver.findElement(By.xpath("//a[normalize-space()='200']")).sendKeys(Keys.ENTER);
    }

    @Then("Showing result related with {string}")
    public void showingResultRelatedWith(String arg0) {
        driver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code.')]")).isDisplayed();
        String urlStatusCode = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code.')]")).getText();
        System.out.println(urlStatusCode);
        driver.close();
        driver.quit();
    }
}
