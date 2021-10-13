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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WishlistTest {

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
	public void wishlistTest() {
		
		driver.navigate().to("https://www.militaryshop.rs/moj-nalog/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.findElement(By.id("username")).sendKeys("marked.one1911@gmail.com");
		driver.findElement(By.id("password")).sendKeys("lozinkaNova");
		driver.findElement(By.cssSelector(".woocommerce-form-login .button")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/shop/oprema/airsoft-oprema/puske-za-airsoft/ak105-cyma-cm-040i-airsoft-metalna-puska/");
		
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.cssSelector(".skip-lazy"));
		actions.moveToElement(target).perform();
		
		driver.findElement(By.cssSelector(".absolute .icon-heart")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/wishlist/");
		assertEquals("https://www.militaryshop.rs/wishlist/", driver.getCurrentUrl());
		
		assertThat(driver.findElement(By.linkText("AK105 CYMA CM.040I airsoft metalna puška")).getText(), is("AK105 CYMA CM.040I airsoft metalna puška"));
	}
}
