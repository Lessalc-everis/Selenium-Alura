package br.com.alura.leilao.lances;


import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;

public class LancesPage extends PageObject{

	private static final String URL_LANCES = "http://localhost:8080/leiloes/2";
		
	public LancesPage(WebDriver browser) {
		// TODO Auto-generated constructor stub
		super(browser);
		this.browser.navigate().to(URL_LANCES);
	}
	
	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().contains(URL_LANCES);
	}

	public boolean isTituloLeilaoVisivel() {
		return browser.getPageSource().contains("Dados do Leilão");
	}
	
	
	
}
