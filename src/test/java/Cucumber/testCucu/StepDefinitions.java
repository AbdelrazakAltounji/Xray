package Cucumber.testCucu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.junit.Test;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import io.cucumber.java.After;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;




import java.net.MalformedURLException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;





public class StepDefinitions {
	//private String today;
	
	//public static WebDriver driver = new FirefoxDriver();
	WebDriver driver;
	@Given("Ouvrir et lancer firefox")
	public void visit_google() {
		System.setProperty("webdriver.gecko.driver","/Xray/src/test/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		}
	
	@When("Je cherche pour le mot {string}")
	public void chercher_mot(String query) {
		//Enter Something to search for
		WebElement element = driver.findElement(By.name("q"));
		//Submit the form.Webdriver will find the form for us from the element
		element.sendKeys(query);
		//Now submit the form.WebDriver will find the form for us from the element
		element.submit();
		
		
	}
	
	@Then("Le titre de la page doit commencer par {string}")
	public void checkTitle(String titleStartsWith) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(titleStartsWith);}
		});
	}
	
	
	@After()
	public void closeBrowser() {
		driver.quit();
	}

}
