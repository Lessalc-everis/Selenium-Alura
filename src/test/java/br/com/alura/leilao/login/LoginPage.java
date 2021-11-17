package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	
	public LoginPage() {
		super(null);
		browser.navigate().to(URL_LOGIN);		
	}
	
	public void preencheFormularioDeLogin(String user, String password) {
		browser.findElement(By.id("username")).sendKeys(user);
		browser.findElement(By.id("password")).sendKeys(password);		
	}

	public LeiloesPage efetuaLogin() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public boolean isPaginaDeLeiloes() {
		return browser.getCurrentUrl().equals("http://localhost:8080/leiloes");
	}

	public Object getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();			
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean isPaginaDeLoginError() {
		return browser.getCurrentUrl().equals("http://localhost:8080/login?error");
	}

	public boolean contemUsuarioInvalido() {
		return browser.getPageSource().contains("Usuário e senha inválidos.");
	}
	
	
	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}
	

	public void acessaPaginaDeLeilaoId(int id) {
		this.browser.navigate().to("http://localhost:8080/leiloes/"+id);
	}
	
	
	
	

}
