package br.com.alura.leilao.login;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void inicializaLoginPage() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void fechar() {
		paginaDeLogin.fechaBrowser();		
	}
	
	

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuaLogin();
	
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertTrue(paginaDeLogin.isPaginaDeLeiloes());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
		
	}
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
		paginaDeLogin.preencheFormularioDeLogin("invalido", "123456");
		paginaDeLogin.efetuaLogin();
		
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginError());
		Assert.assertTrue(paginaDeLogin.contemUsuarioInvalido());
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.acessaPaginaDeLeilaoId(2);
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}
	
}
