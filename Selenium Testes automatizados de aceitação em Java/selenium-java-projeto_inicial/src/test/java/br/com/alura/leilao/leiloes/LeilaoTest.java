package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeilaoTest {

	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage pageCadastro;
	@BeforeEach
	public void BeforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormulario("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
		this.pageCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}

	@Test
	public void deveriaCadastrarLeilao() {
	
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia" + hoje;
		String valor = "500.00";
		
		this.paginaDeLeiloes = pageCadastro.cadastrarLeilao(nome, valor, hoje);
		
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void deveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = pageCadastro.cadastrarLeilao("", "", "");
		
		Assert.assertFalse(this.pageCadastro.isPaginaAtual());
		Assert.assertTrue(this.pageCadastro.isMensagensDeValidacaoVisiveis());
	}
}
