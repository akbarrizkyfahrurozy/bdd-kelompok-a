package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginform {

    WebDriver driver;
    @Given("I Open browser chromedriver")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @And("Open website the-internet.herokuapp.comm")
    public void openWebsite() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/");
        Thread.sleep(1000);
    }
    @And("Located on the-internet.herokuapp.comm")
    public void locatedOnTheInternet() {
        driver.findElement(By.xpath("//a[normalize-space()='Form Authentication']")).isDisplayed();
    }
    @When("I click Form Authentication")
    public void iClickFormAuthentication() {
        driver.findElement(By.xpath("//a[normalize-space()='Form Authentication']")).sendKeys(Keys.ENTER);
    }
    @And("Open Form Authentication")
    public void openFormAuthentication() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
    }
    @Then("Showing result related with Form Authentication")
    public void showingResultRelatedWithFormAuthentication() {
        String urlFormAuth = driver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]")).getText();
        System.out.println(urlFormAuth);
        driver.close();
        driver.quit();
    }
}
