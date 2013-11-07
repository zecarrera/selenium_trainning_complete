package br.org.cesar.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;

import br.org.cesar.common.HomePage;
import br.org.cesar.util.Utils;

/**
 * Classe de testes com cenários relacionados a página inicial
 */
public class HomePageValidation extends BaseTestcase{

	@Before
	public void before() throws Exception {
	  HomePage.clickCompanyLogo();
	}


	/**
	 *  Open home screen and verify page title 
	 */
	@Test
	public void assertHomeScreenTitle() {
		driver.manage().window().maximize();
		Utils.takeScreenshot("maximized");
		HomePage.clickCompanyLogo();
		HomePage.assertTitle("C.E.S.A.R - Centro de Estudos e Sistemas Avançados do Recife");	
	}
	
	/**
	 *  Performs a search with fixed text on page 
	 */
	@Test
	public void performSimpleSearch() {
		HomePage.assertTitle("C.E.S.A.R - Centro de Estudos e Sistemas Avançados do Recife");	
		HomePage.performSearch("testes de software");
		HomePage.clickSearchButton();
		HomePage.isSearchResultsDisplayed();
	}

	
	/**
	 * Performs a search with empty text
	 */
	@Test
	public void searchEmptyText(){
		HomePage.performSearch("");
		HomePage.clickSearchButton();
		HomePage.isEmptySearchResultsDisplayed();
	}
			
	/**
	 * Clicks link to change page language to english
	 */
	@Test
	public void changeToEnglish(){
		HomePage.clickEnglishLink();
		HomePage.isTitleInEnglish();
	}
	
	/**
	 * Opens an fills out fale conosco form
	 */
	@Test
	public void openFaleConoscoPage(){
		HomePage.clickFaleConoscoLink();
		HomePage.fillOutFaleConoscoForm("jose", "jcan@cesar.org.br", "assunto", "mensg");
		HomePage.assertErrorMessageIsShown();
	}
	
	/**
	 *  Performs a search with fixed text on page (with screenshot) 
	 */
	@Test
	public void performSimpleSearchScrenshot() {
		HomePage.assertTitle("C.E.S.A.R - Centro de Estudos e Sistemas Avançados do Recife");	
		HomePage.performSearch("testes de software");
		Utils.takeScreenshot(this.getClass().getName().substring(19));
		HomePage.clickSearchButton();
		HomePage.isSearchResultsDisplayed();
	}
	@After
	public void after() throws Exception {
		HomePage.clickSalaDeImprensa();
	}
}
