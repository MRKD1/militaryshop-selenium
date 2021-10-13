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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchTest {

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
	public void searchTest() {
		driver.get("https://www.militaryshop.rs/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.findElement(By.cssSelector(".is-small > .icon-search")).click();
		driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("MS-R28" + Keys.ENTER);
		
		assertThat(driver.findElement(By.cssSelector(".product_title")).getText(), is("Taktička profesionalna baterijska lampa Jetbeam Niteye MS-R28"));
	}

}
