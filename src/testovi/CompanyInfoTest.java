package testovi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

public class CompanyInfoTest {

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
	public void companyInfoTest() throws IOException {
		
		driver.get("https://www.militaryshop.rs/o-nama/");
		driver.manage().window().setSize(new Dimension(1440, 900));
		
		String oFirmi = driver.findElement(By.cssSelector("p:nth-child(6)")).getText();
		String podaciFirme = driver.findElement(By.cssSelector("p:nth-child(9)")).getText();
		String radnoVreme = driver.findElement(By.cssSelector("p:nth-child(12)")).getText();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("test-report.txt", true));
		
	
		writer.append(oFirmi);
		writer.newLine();
		writer.newLine();
		writer.append(podaciFirme);
		writer.newLine();
		writer.newLine();
		writer.append(radnoVreme);
		writer.newLine();
		writer.newLine();
		writer.close();
	}
}
	
		
	
		
		
		
			
		
		
		
	

