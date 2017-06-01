package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		//FirefoxProfile fp = new FirefoxProfile();
		//fp.setAcceptUntrustedCertificates(true);
		capabilities.setCapability("acceptInsecureCerts", true);
		capabilities.setJavascriptEnabled(true);
		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.get("http://odiolitaliano.altervista.org/HTML/palindroma.html");
		WebElement input = driver.findElement(By.id("palindroma"));
		WebElement submit = driver.findElement(By.id("submit"));
		input.sendKeys("cane bello con tanti denti bianchi lunghi");
		submit.submit();
		//driver.close();
	}
}
