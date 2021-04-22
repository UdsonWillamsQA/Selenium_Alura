package br.com.alura.leilao.login;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

	@Test
	public void deveriaEfeturarLoginComDadosValidos() {
		paginaDeLogin.preencheFormulario("fulano", "pass");
		paginaDeLogin.efetuaLogin();
		
		Assert.assertTrue(paginaDeLogin.isLeilaoPage());
		Assert.assertEquals("fulano", paginaDeLogin.getUserLogado());
	}

	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
		paginaDeLogin.preencheFormulario("aa", "aaa");
		paginaDeLogin.efetuaLogin();

		Assert.assertTrue(paginaDeLogin.isLoginPageErro());	
		Assert.assertNull(paginaDeLogin.getUserLogado());
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));

	}

	@Test
	public void naoDeveriaAcesarPaginaRestritaSemEstarLogado() {
		
		paginaDeLogin.navegaParaPaginaDeLeiloes();

		Assert.assertTrue(paginaDeLogin.isLoginPage());	
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}
}
