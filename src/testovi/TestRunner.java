package testovi;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;




public class TestRunner {

	public static void main(String[] args) throws IOException {
		
		Logger l = Logger.getLogger(TestRunner.class.toString());
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("test-report.txt", true));
		
		
		Result result = JUnitCore.runClasses(LogInTest.class);
		writer.newLine();
		writer.append("LogInTest - Testiranje prijave: " + result.wasSuccessful());
		l.info("LogInTest - Testiranje prijave: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(DataCheckTest.class);
		writer.newLine();
		writer.append("DataCheckTest - Testiranje podataka korisnika: " + result.wasSuccessful());
		l.info("DataCheckTest - Testiranje podataka korisnika: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(PriceTest.class);
		writer.newLine();
		writer.append("PriceTest - Testiranje cene: " + result.wasSuccessful());
		l.info("PriceTest - Testiranje Testiranje cene: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(ProductsTest.class);
		writer.newLine();
		writer.append("ProductsTest - Testiranje dodavanja proizoda u korpu: " + result.wasSuccessful());
		l.info("ProductsTest - Testiranje dodavanja proizoda u korpu: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(WishlistTest.class);
		writer.newLine();
		writer.append("WishlistTest - Testiranje dodavanja omiljenih proizvoda: " + result.wasSuccessful());
		l.info("WishlistTest - Testiranje dodavanja omiljenih proizvoda: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(SearchTest.class);
		writer.newLine();
		writer.append("SearchTest - Testiranje pretrazivanja: " + result.wasSuccessful());
		l.info("SearchTest - Testiranje pretrazivanja: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(SizeSelectorTest.class);
		writer.newLine();
		writer.append("SizeSelectorTest - Testiranje odabira velicine proizvoda: " + result.wasSuccessful());
		l.info("SizeSelectorTest - Testiranje odabira velicine proizvoda: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(EditAccountTest.class);
		writer.newLine();
		writer.append("EditAccountTest - Testiranje izmene podataka o nalogu: " + result.wasSuccessful());
		l.info("EditAccountTest - Testiranje izmene podataka o nalogu: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(CompanyInfoTest.class);
		writer.newLine();
		writer.append("CompanyTest - Dodavanje informacija o kompaniji: " + result.wasSuccessful());
		l.info("CompanyTest - Dodavanje informacija o kompaniji: " + result.wasSuccessful());
		writer.newLine();
		
		result = JUnitCore.runClasses(PerformanceTest.class);
		writer.newLine();
		writer.append("PerformanceTest - Testiranje performansi sajta: " + result.wasSuccessful());
		l.info("PerformanceTest - Testiranje performansi sajta: " + result.wasSuccessful());
		writer.newLine();
		writer.newLine();
		writer.close();
	}

}
