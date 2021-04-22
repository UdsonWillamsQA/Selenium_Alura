package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObject {

	protected WebDriver driver;
	
	public PageObject(WebDriver driver) {
		if (driver == null) {
			this.driver = new FirefoxDriver();			
		}else {
		this.driver = driver;
		}
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void fechar() {
		this.driver.quit();
	}
}
