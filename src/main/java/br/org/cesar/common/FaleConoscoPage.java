package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/*
 * Executa todas as acoes na pagina Inicial
 */
public class FaleConoscoPage {

	/*
	 * Instancia privada do webDriver que vira da suite de teste
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/*
	 * Construtor que ira adicionar a instancia do WebDriver para utilizacao dos metodos
	 */
	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	 // The home page contains several HTML elements that will be represented as WebElements.
    // The locators for these elements should only be defined once.
	static By faleConoscoLocator = By.linkText("Fale Conosco");
	static By nameFieldLocator = By.name("your-name");
	static By emailFieldLocator = By.name("your-email");
	static By subjectFieldLocator = By.name("your-subject");
	static By messageFieldLocator = By.name("your-message");
	static By enviarButtonLocator = By.xpath("//input[@value='Enviar']");
	static By faleConoscoErrorMessageLocator = By.xpath("//form/div[2]");

	public FaleConoscoPage() {
	}

	
	/**
	 * Clicks fale conosco link
	 */
	public static void clickFaleConoscoLink(){
		Utils.isVisible(faleConoscoLocator);
		driver.findElement(faleConoscoLocator).click();
	}
	
	/**
	 * Fills out Nome field
	 */
	public static void fillOutNome(String nome){
		driver.findElement(nameFieldLocator).sendKeys(nome);
	}
	
	/**
	 * Fills out Email field
	 */
	public static void fillOutEmail(String email){
		driver.findElement(emailFieldLocator).sendKeys(email);
	}
	
	/**
	 * Fills out Assunto field
	 */
	public static void fillOutAssunto(String assunto){
		driver.findElement(subjectFieldLocator).sendKeys(assunto);
	}
	
	/**
	 * Fills out Mensagem field
	 */
	public static void fillOutMensagem(String mensagem){
		driver.findElement(messageFieldLocator).sendKeys(mensagem);
	}
	
	/**
	 * Click enviar button for fale conosco form
	 */
	public static void clickEnviarButton(){
		driver.findElement(enviarButtonLocator).click();
	}
	/**
	 * Fills out fale conosco form
	 */
	public static void fillOutFaleConoscoForm(String nome, String email, String assunto, String mensagem){
		fillOutNome(nome);
		fillOutEmail(email);
		fillOutAssunto(assunto);
		fillOutMensagem(mensagem);
		clickEnviarButton();
	}
	
	/**
	 * Asserts if error message is shown on fale conosco form
	 */
	public static void assertErrorMessageIsShown() {
		Utils.isVisible(faleConoscoErrorMessageLocator);
		Assert.assertEquals("Ocorreram erros de validação. Por favor confira os dados e envie novamente.",driver.findElement(faleConoscoErrorMessageLocator).getText());
	}

}