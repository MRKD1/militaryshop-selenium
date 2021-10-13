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

public class PriceTest {

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
	public void priceTest() throws InterruptedException{
		
		driver.get("https://www.militaryshop.rs/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.navigate().to("https://www.militaryshop.rs/moj-nalog/");
		
		driver.findElement(By.id("username")).sendKeys("marked.one1911@gmail.com");
		driver.findElement(By.id("password")).sendKeys("lozinkaNova");
		driver.findElement(By.cssSelector(".woocommerce-form-login .button")).click();
				
		driver.navigate().to("https://www.militaryshop.rs/shop/rancevi-i-torbe/pentagon-rancevi/kyler-bag-ranac-pentagon-crni-k16073/");
		driver.findElement(By.name("add-to-cart")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/shop/rancevi-i-torbe/pentagon-rancevi/pentagon-tac-maven-assault-ranac-50-litara-zelena-boja/");
		driver.findElement(By.name("add-to-cart")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/korpa/");
		assertEquals("https://www.militaryshop.rs/korpa/", driver.getCurrentUrl());
		
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2) > .woocommerce-Price-amount > bdi")).getText(), is("18.100 RSD"));
		
		driver.findElement(By.className("remove")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("remove")).click();
	}

}
