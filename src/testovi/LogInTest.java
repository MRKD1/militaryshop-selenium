package testovi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest{

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "X:\\Download X\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void logInTest()  throws InterruptedException {
		driver.get("https://www.militaryshop.rs/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.navigate().to("https://www.militaryshop.rs/moj-nalog/");
		
		driver.findElement(By.id("username")).sendKeys("marked.one1911@gmail.com");
		driver.findElement(By.id("password")).sendKeys("lozinkaNova");
		driver.findElement(By.cssSelector(".woocommerce-form-login .button")).click();
		
		Thread.sleep(3000);
		
		assertThat(driver.findElement(By.cssSelector("p > strong:nth-child(1)")).getText(), is("marked.one1911"));
		
	}

}
