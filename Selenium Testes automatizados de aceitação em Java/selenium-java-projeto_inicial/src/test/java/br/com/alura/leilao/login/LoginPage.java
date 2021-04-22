package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject{

	private static final String URL_LOGIN = "http://localhost:8080/login";

	public LoginPage() {
		super(null);		
		driver.navigate().to(URL_LOGIN);
	}

	public void preencheFormulario(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage efetuaLogin() {
		driver.findElement(By.className("btn-primary")).click();
		return new LeiloesPage(driver);
	}

	public boolean isLoginPage() {
		return driver.getCurrentUrl().equals(URL_LOGIN);
	}

	public boolean isLeilaoPage() {
		return driver.getCurrentUrl().equals("http://localhost:8080/leiloes");
	}

	public String getUserLogado() {
		try {
			return driver.findElement(By.id("userLogado")).getText();
		} catch (Exception e) {
			return null;
		}
	}

	public void navegaParaPaginaDeLeiloes() {
		driver.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean contemTexto(String texto) {
		return driver.getPageSource().contains(texto);
	}

	public boolean isLoginPageErro() {
		return driver.getCurrentUrl().equals(URL_LOGIN + "?error");
	}
}
