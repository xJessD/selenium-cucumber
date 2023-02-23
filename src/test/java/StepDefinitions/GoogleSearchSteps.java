package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("Inside step - browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	@And("user is on google Search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside step - user is on Google Home page");
		driver.get("https://www.google.com.au/");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("Inside step - user enters search query");
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));
		searchBox.sendKeys("Test automation");
		
	}

	@When("hits enter")
	public void hits_enter() {
		System.out.println("Inside step - user submits query");
		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));
		searchBox.sendKeys(Keys.ENTER);
	}

	@Then("user is navigated search results")
	public void user_is_navigated_search_results() {
		System.out.println("Inside step - user is navigated to results page");
		driver.getPageSource().contains("DevOps Test Automation | Atlassian");
		
		driver.close();
		driver.quit();
	}
}
