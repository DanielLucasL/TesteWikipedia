package exselenium;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestaWikipedia {

	protected WebDriver driver;

	@BeforeAll
	public static void configuraDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\danie\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}

	@BeforeEach
	public void createDriver() {

		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
	}

	@Test
	public void testaTituloBuscaWikipedia() throws InterruptedException {
		WebElement search = driver.findElement(By.name("search"));
		search.sendKeys("Beyoncé");
		search.submit();	
		WebElement aniversario = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div[2]/div[3]/div[1]/table[1]/tbody/tr[5]/td[2]/span/a[1]"));
		assertTrue(aniversario.getText().contains("4 de setembro"));	
	}
	

	@AfterEach
	public void quitDriver() {
		driver.quit();
	}
}
