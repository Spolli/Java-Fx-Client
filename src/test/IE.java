package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "src/test/IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability("acceptInsecureCerts", true);
		capabilities.setJavascriptEnabled(true);
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.get("http://odiolitaliano.altervista.org/HTML/palindroma.html");
		WebElement input = driver.findElement(By.id("palindroma"));
		WebElement submit = driver.findElement(By.id("submit"));
		//input.click();
		input.sendKeys("anna");
		submit.submit();
		driver.close();
	}

}
