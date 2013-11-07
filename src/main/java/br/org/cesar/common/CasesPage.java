package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/*
 * Executa todas as acoes de SignIn
 */
public class CasesPage {

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
	static By casesMenuLocator = By.linkText("CASES");
	static By casesCombobox = By.name("type");

	
	public CasesPage() {
	}

	/**
	 * Clicks the CASES menu
	 */
	public static void clickCasesMenu() { 
		driver.findElement(casesMenuLocator).click();
	}

	/**
	 * Select a case
	 */
	public static void selectACase(String chosenCase){
		Select selectCombo = new Select(driver.findElement(casesCombobox));
		selectCombo.selectByVisibleText(chosenCase);;
//		new Select(driver.findElement(By.name("type"))).selectByVisibleText(chosenCase);;
	}
	
	
	/**
	 * Open a specified case details
	 * @param item
	 */
	public static void viewCaseDetails(String item) {
		driver.findElement(By.xpath("//img[@alt='"+item +"']")).click();
	}

	/**
	  * Asserts which is the first case displayed
	  * @param texto must be the first item listed
	  */
	public static void assertFirstCaseDisplayed(String texto) {
		try{
			wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("p"), texto));
		}catch(TimeoutException e){
			Assert.fail();
		}
	}

	/**
	 * Assert case title is correct
	 * @param item  
	 */
	public static void assertCaseDetails(String item) {
		Utils.isVisible(By.cssSelector("h2"));
		String subTitle = driver.findElement(By.cssSelector("h2")).getText();
		Assert.assertEquals(item, subTitle);
	}
	
}