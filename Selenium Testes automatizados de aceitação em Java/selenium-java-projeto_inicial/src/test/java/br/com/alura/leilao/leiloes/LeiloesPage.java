package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject{

	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";

	public LeiloesPage(WebDriver driver) {
		super(driver);
	}

	public boolean isLeilaoPage() {
		return driver.getCurrentUrl().equals("http://localhost:8080/leiloes");
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.driver.navigate().to(URL_CADASTRO_LEILOES);
		return new CadastroLeilaoPage(driver);
	}
	
	public boolean isLeilaoCadastrado(String nome, String valor, String hoje) {
		WebElement linhaDaTabela = this.driver.findElement(By.cssSelector("#tabelaLeiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaData = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		return colunaNome.getText().equals(nome)&& 
			   colunaData.getText().equals(hoje) &&
			   colunaValorInicial.getText().equals(valor);
	}
}
