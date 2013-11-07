package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;


/**
 * Página que disponibiliza os serviços (ações) presentes na home page do CESAR.ORG.BR
 * @author jcan
 *
 */
public class HomePage {

	/**
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/**
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	/**
	 * Definição única dos locators utilizados na página
	 */
	static By companyLogoLocator = By.cssSelector("a.block.indent");
	static By searchFieldLocator = By.id("s");
	static By searchButtonLocator = By.id("searchsubmit");
	static By searchResultTitleLocator = By.id("title-search-result");
	static By faleConoscoLocator = By.linkText("Fale Conosco");
	static By nameFieldLocator = By.name("your-name");
	static By emailFieldLocator = By.name("your-email");
	static By subjectFieldLocator = By.name("your-subject");
	static By messageFieldLocator = By.name("your-message");
	static By enviarButtonLocator = By.xpath("//input[@value='Enviar']");
	static By faleConoscoErrorMessageLocator = By.xpath("//form/div[2]");
	static By englishLinkLocator = By.linkText("English");
	static By salaDeImprensaLocator = By.linkText("Sala de Imprensa");

	public HomePage() {
	}

	/**
	 * Clica no logo da empresa 
	 */
	public static void clickCompanyLogo(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyLogoLocator));
		driver.findElement(companyLogoLocator).click();
	}	
	
	/**
	 * Digita o texto passado no campo de busca
	 */
	public static void performSearch(String searchText) { 
		wait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator));
		driver.findElement(searchFieldLocator).sendKeys(searchText);
	}
	
	/**
	 * Clicar no botão buscar
	 */
	public static void clickSearchButton() { 
		driver.findElement(searchButtonLocator).click(); 
	}
	
	/**
	 * Clicar no link English
	 */
	public static void clickEnglishLink(){
		driver.findElement(englishLinkLocator).click();
	}
	
	/**
	 * Clicar no link fale conosco
	 */
	public static void clickFaleConoscoLink(){
		Utils.isVisible(faleConoscoLocator);
		driver.findElement(faleConoscoLocator).click();
	}
	
	/**
	 * Preencher campo nome
	 */
	public static void fillOutNome(String nome){
		driver.findElement(nameFieldLocator).sendKeys(nome);
	}
	
	/**
	 * Preencher campo Email
	 */
	public static void fillOutEmail(String email){
		driver.findElement(emailFieldLocator).sendKeys(email);
	}
	
	/**
	 * Preencher campo Assunto
	 */
	public static void fillOutAssunto(String assunto){
		driver.findElement(subjectFieldLocator).sendKeys(assunto);
	}
	
	/**
	 * Preencher campo Mensagem 
	 */
	public static void fillOutMensagem(String mensagem){
		driver.findElement(messageFieldLocator).sendKeys(mensagem);
	}
	
	/**
	 * Clicar no botão enviar para o formulário fale conosco
	 */
	public static void clickEnviarButton(){
		driver.findElement(enviarButtonLocator).click();
	}
	
	/**
	 * Preencher formulário fale conosco
	 */
	public static void fillOutFaleConoscoForm(String nome, String email, String assunto, String mensagem){
		fillOutNome(nome);
		fillOutEmail(email);
		fillOutAssunto(assunto);
		fillOutMensagem(mensagem);
		clickEnviarButton();
	}
	
	/**
	 * Checks if search page title is the one expected
	 */
	public static void isSearchResultsDisplayed(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultTitleLocator));
		String title = driver.findElement(searchResultTitleLocator).getText();
		Assert.assertEquals(title, "Resultado da Busca");
	}
	
	/**
	 * Checar se o título da página é o esperado
	 */
	public static void isEmptySearchResultsDisplayed() {
		Utils.isVisible(searchResultTitleLocator);
		Assert.assertEquals("Nenhum resultado encontrado.", driver.findElement(searchResultTitleLocator).getText());
	}
	
	/**
	 * Checks if page title is the one expected
	 * @param texto
	 */
	public static void assertTitle(String texto){
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyLogoLocator));
		String title = driver.getTitle();
		Assert.assertEquals(title, texto);
	}

	/**
	 * Asserts if error message is shown on fale conosco form
	 */
	public static void assertErrorMessageIsShown() {
		Utils.isVisible(faleConoscoErrorMessageLocator);
		Assert.assertEquals("Ocorreram erros de validação. Por favor confira os dados e envie novamente.",driver.findElement(faleConoscoErrorMessageLocator).getText());
	}


	/**
	 * Asserts if page title is in english
	 */
	public static void isTitleInEnglish(){
		Assert.assertEquals("C.E.S.A.R (English version)", driver.getTitle());
	}

	public static void clickSalaDeImprensa() {
		driver.findElement(salaDeImprensaLocator).click();
	}
}