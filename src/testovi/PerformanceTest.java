package testovi;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PerformanceTest {

	private WebDriver driver;
	private static Map<String, Object> vars;
	JavascriptExecutor js;
	private static BufferedWriter writer;
	
	@BeforeClass
	public static void beforeClass() throws IOException {
		writer = new BufferedWriter(new FileWriter("test-report.txt", true));
		vars = new HashMap<String, Object>();
	}
	
	@AfterClass
	public static void avg() throws IOException {
		long avg = (Long.parseLong(vars.get("test1").toString()) + Long.parseLong(vars.get("test2").toString()) + Long.parseLong(vars.get("test3").toString()) + Long.parseLong(vars.get("test4").toString()) + Long.parseLong(vars.get("test5").toString()))/5;
		writer.newLine();
		writer.close();
  }
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "X:\\Download X\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test1() {
		long start = System.currentTimeMillis();
		driver.get("https://www.militaryshop.rs/");
		long end = System.currentTimeMillis();
		vars.put("test1", (end - start));
		
		try {
			writer.newLine();
			writer.append("Performance Test1 " + vars.get("test1") + "ms");
			writer.newLine();
		  } catch (IOException t) {
			t.printStackTrace();
		  }
	}
	
	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		driver.get("https://www.militaryshop.rs/shop/obuca/vojne-cizme/ruske-vojne-cizme-garsing/crne-borbene-poluduboke-patike-garsing-alligator/");
		long end = System.currentTimeMillis();
		vars.put("test2", (end - start));
		
		try {
			writer.append("Performance Test2 " + vars.get("test2") + "ms");
			writer.newLine();
		  } catch (IOException t) {
			t.printStackTrace();
		  }
	}
	
	@Test
	public void test3() {
		long start = System.currentTimeMillis();
		driver.get("https://www.militaryshop.rs/kontakt/contact-us/");
		long end = System.currentTimeMillis();
		vars.put("test3", (end - start));
		
		try {
			writer.append("Performance Test3 " + vars.get("test3") + "ms");
			writer.newLine();
		  } catch (IOException t) {
			t.printStackTrace();
		  }
	}
	
	@Test
	public void test4() {
		long start = System.currentTimeMillis();
		driver.get("https://www.militaryshop.rs/shop/oprema/zastitna-oprema/maske-za-lice/pamucna-zastitna-maska-za-lice/");
		long end = System.currentTimeMillis();
		vars.put("test4", (end - start));
		
		try {
			writer.append("Performance Test4 " + vars.get("test4") + "ms");
			writer.newLine();
		  } catch (IOException t) {
			t.printStackTrace();
		  }
	}
	
	@Test
	public void test5() {
		long start = System.currentTimeMillis();
		driver.get("https://www.militaryshop.rs/o-nama/");
		long end = System.currentTimeMillis();
		vars.put("test5", (end - start));
		
		try {
			writer.append("Performance Test5 " + vars.get("test5") + "ms");
			writer.newLine();
		  } catch (IOException t) {
			t.printStackTrace();
		  }
	}
	


}
