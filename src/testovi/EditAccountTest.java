package testovi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditAccountTest {

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
	public void editAccountTest() {
		
		driver.get("https://www.militaryshop.rs/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.navigate().to("https://www.militaryshop.rs/moj-nalog/");
		
		driver.findElement(By.id("username")).sendKeys("marked.one1911@gmail.com");
		driver.findElement(By.id("password")).sendKeys("lozinkaNova");
		driver.findElement(By.cssSelector(".woocommerce-form-login .button")).click();
	
		driver.navigate().to("https://www.militaryshop.rs/my-account/edit-account/");
		
		driver.findElement(By.id("account_first_name")).clear();
		driver.findElement(By.id("account_last_name")).clear();
		
		driver.findElement(By.id("account_first_name")).sendKeys("Zeljko");
		driver.findElement(By.id("account_last_name")).sendKeys("Memarovic");
		driver.findElement(By.cssSelector(".woocommerce-Button")).click();
		driver.navigate().to("https://www.militaryshop.rs/my-account/edit-account/");
		assertThat(driver.findElement(By.xpath("//input[@id='account_first_name']")).getAttribute("value"), is("Zeljko"));
		assertThat(driver.findElement(By.xpath("//input[@id='account_last_name']")).getAttribute("value"), is("Memarovic"));
	}
}