package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.utility.Data;

public class browserInteraction {

	public static FirefoxDriver inizializzazione(){
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
      DesiredCapabilities capabilities = DesiredCapabilities.firefox();
      capabilities.setCapability("marionette", true);
    	capabilities.setCapability("acceptInsecureCerts", true);
    	capabilities.setJavascriptEnabled(true);
      return new FirefoxDriver(capabilities);
	}

	/*
	 //* Hide WebBrowser
	 public static PhantomJSDriver inizializzazione(){
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
	    DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
	    //capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src/main/resources/phantomjs.exe");
	    //capabilities.setCapability("phantomjs.binary.path", "src/main/resources/geckodriver.exe");
	    capabilities.setCapability("marionette", true);
	    capabilities.setCapability("acceptInsecureCerts", true);
	    capabilities.setJavascriptEnabled(true);
	    return new PhantomJSDriver(capabilities);
	}
	*/

	public static WebDriver driver = browserInteraction.inizializzazione();

	public static void login(Data temp){
		driver.get("https://area51.og.ge.com");
		WebElement input1 = driver.findElement(By.id("input_1"));
		WebElement input2 = driver.findElement(By.id("input_2"));
		WebElement input3 = driver.findElement(By.id("input_3"));
		WebElement submit = driver.findElement(By.cssSelector("input.credentials_input_submit"));
		input1.sendKeys(temp.getSso());
		input2.sendKeys(temp.getPwd());
		input3.sendKeys(temp.getPin());
		submit.submit();
	}

	public static void retry(){
		driver.close();
		driver = browserInteraction.inizializzazione();
	}

	public static void close(){
		driver.close();
	}

	public static List<WebElement> sharedFolder(){
		return driver.findElements(By.className("caption"));
	}

	public static void accept(){
		WebElement accept = driver.findElement(By.linkText("Accept"));
		accept.click();
	}

	public static void existsLink(String link) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link)));
	}

	public static void existsId(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	public static void existsClass(String className) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(className)));
	}

	public static boolean isID(String id){
		WebElement web = driver.findElement(By.id(id));
		if(web.isDisplayed() && web.isEnabled())
			return true;
		else
			return false;
	}

	public static boolean isName(String name){
		WebElement web = driver.findElement(By.name(name));
		if(web.isDisplayed() && web.isEnabled())
			return true;
		else
			return false;
	}

	public static void takeToken(String token){
		WebElement input = driver.findElement(By.name("_F5_challenge"));
		WebElement submit = driver.findElement(By.className("credentials_input_password"));
		input.sendKeys(token);
		submit.submit();
	}
}
