package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/*
 * Executa todas as acoes de SignIn
 */
public class UnidadesPage {

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
	
	
	public UnidadesPage() {
	}

	/**
	 * Clicks the unidades menu
	 */
	public static void clickSUnidadesMenu() { 
		driver.findElement(By.linkText("UNIDADES")).click();
	}

	/**
	 * Clicks Sub-menu item
	 */
	public static void clickSubMenu(String subMenu) { 
		Utils.isVisible(By.linkText(subMenu));
		driver.findElement(By.linkText(subMenu)).click(); 
	}
	
	/**
	 * Clicks share by e-mail
	 */
	public static void clickEmailIcon(){
		driver.findElement(By.cssSelector("span.stMainServices.st-email-counter")).click();
	}
	
	/**
	 * Fill out email form
	 */
	public static void fillOutEmailForm(String destino, String origem, String mensagem){
		driver.switchTo().frame("stLframe");
		driver.findElement(By.id("txtYourAddr")).sendKeys(destino);
		driver.findElement(By.id("txtFromAddr")).sendKeys(origem);
		driver.findElement(By.id("txtMessage")).sendKeys(mensagem);
	}
	
	/**
	 * Click send email button
	 */
	 public static void confirmEmailShareButton(Boolean sendMessage){
		 if (sendMessage){
			 driver.findElement(By.id("btnShareSend")).click();
		 }else{
			 driver.findElement(By.id("btnShareCancel")).click();
		 }
	 }
	 
	 /**
	  * Asserts if button is present
	  */
	 public static void assertButtonPresent(By element){
			driver.switchTo().frame("stLframe");
		 try{
			 wait.until(ExpectedConditions.presenceOfElementLocated(element));
		 } catch(NoSuchElementException e){
			 Assert.fail();
		 }
	 }
	 
	 /**Asserts sub-title of the opened page
	  * 
	  * @param texto that must be set as sub-title
	  */
	public static void assertSubTitle(String texto) {
		Utils.isVisible(By.cssSelector("h2"));
		String subTitle = driver.findElement(By.cssSelector("h2")).getText();
		Assert.assertEquals(texto, subTitle);
	}

	/**
	 * Asserts if success by email message has been displayed
	 */
	public static void assertEmailsuccessfullySent() {
		Utils.isVisible("msg_share_success");
		Assert.assertEquals("Your message was successfully shared! Log-in with FastShare to share with just one click next time.",
				driver.findElement(By.id("msg_share_success")).getText());
	}

	public static void assertEmailnotSent() {
		Utils.isVisible("chicklet_search_field");
		Assert.assertTrue(true);
	}

	public static void clickTwitterIcon() {
		// TODO Auto-generated method stub
		
	}
}