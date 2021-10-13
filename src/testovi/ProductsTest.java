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

public class ProductsTest {

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
	public void productsTest() {
		driver.get("https://www.militaryshop.rs/moj-nalog/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.findElement(By.id("username")).sendKeys("marked.one1911@gmail.com");
		driver.findElement(By.id("password")).sendKeys("lozinkaNova");
		driver.findElement(By.cssSelector(".woocommerce-form-login .button")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/shop/rancevi-i-torbe/pentagon-rancevi/kyler-bag-ranac-pentagon-crni-k16073/");
		driver.findElement(By.name("add-to-cart")).click();
	
		
		driver.navigate().to("https://www.militaryshop.rs/shop/odeca/salovi/marama-atreus-shemagh-pentagon/");
		driver.findElement(By.name("add-to-cart")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/shop/oprema/vrece-za-spavanje/kamperska-vreca-high-peak-black-arrow/");
		driver.findElement(By.name("add-to-cart")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/korpa/");
		assertEquals("https://www.militaryshop.rs/korpa/", driver.getCurrentUrl());
		
		
		assertThat(driver.findElement(By.linkText("Kamperska vreća High Peak Black Arrow")).getText(), is("Kamperska vreća High Peak Black Arrow"));
		assertThat(driver.findElement(By.linkText("Marama Atreus Shemagh Pentagon")).getText(), is("Marama Atreus Shemagh Pentagon"));
		assertThat(driver.findElement(By.linkText("RANAC PENTAGON KYLER BAG CRNI K16073")).getText(), is("RANAC PENTAGON KYLER BAG CRNI K16073"));
		
	}

}
