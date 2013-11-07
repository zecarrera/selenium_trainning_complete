package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/*
 * Executa todas as acoes na pagina Inicial
 */
public class AreaDeConhecimentoPage {

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
	
	static By areaDeConhecimentoMenuLocator = By.linkText("ÁREA DE CONHECIMENTO");
	static By testesMenuLocator = By.linkText("Testes123");
	static By pageSubTitleLocator = By.cssSelector("h2");
	
	public AreaDeConhecimentoPage() {
	}

	/**
	 * Clicks Area de Conhecimento menu item
	 */
	public static void clickAreaDeConhecimentoMenu(){
		driver.findElement(areaDeConhecimentoMenuLocator).click();
	}	
	
	/**
	 * Clicks Testes Sub-menu item
	 */
	public static void clickTestesSubMenu() { 
//		Utils.isVisible(testesMenuLocator);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(testesMenuLocator));
		driver.findElement(testesMenuLocator).click(); 
	}

	
	/**
	 * Checks if page sub title is the one expected
	 * @param texto
	 */
	public static void assertSubTitle(String texto){
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageSubTitleLocator));
		String subTitle = driver.findElement(pageSubTitleLocator).getText();
		Assert.assertEquals(subTitle, texto);
	}


}