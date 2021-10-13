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
import org.openqa.selenium.support.ui.Select;

public class SizeSelectorTest {

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
	public void sizeSelectorTest() {
		driver.get("https://www.militaryshop.rs/moj-nalog/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		driver.findElement(By.id("username")).sendKeys("marked.one1911@gmail.com");
		driver.findElement(By.id("password")).sendKeys("lozinkaNova");
		driver.findElement(By.cssSelector(".woocommerce-form-login .button")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/shop/obuca/vojne-cizme/ruske-vojne-cizme-garsing/matrix-crna-poluduboka-cizma-garsing-rusija/");
		Select dropdown = new Select(driver.findElement(By.id("pa_velicina")));
		dropdown.selectByValue("43");
		driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
		
		driver.navigate().to("https://www.militaryshop.rs/korpa/");
		assertEquals("https://www.militaryshop.rs/korpa/", driver.getCurrentUrl());
		
		
		assertThat(driver.findElement(By.linkText("MATRIX Crna poluduboka čizma Garsing Rusija - 43")).getText(), is("MATRIX Crna poluduboka čizma Garsing Rusija - 43"));	
	}
}
