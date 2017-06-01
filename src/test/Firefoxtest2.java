package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefoxtest2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability("acceptInsecureCerts", true);
		capabilities.setJavascriptEnabled(true);
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.get("https://area51.og.ge.com/");
		WebElement input1 = driver.findElement(By.id("input_1"));
		WebElement input2 = driver.findElement(By.id("input_2"));
		WebElement input3 = driver.findElement(By.id("input_3"));
		WebElement logon = driver.findElement(By.className("credentials_input_submit"));
		input1.sendKeys("212606349");
		input2.sendKeys("ciao");
		input3.sendKeys("ciao");
		logon.submit();
		//submit.click();
		//driver.close();
	}
}
