package br.org.cesar.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.common.Selenium;

/**
 * Classe com m�todos de apoio, que otimizam a codifica��o das classes de p�gina.
 * @author jcan
 *
 */
public abstract class Utils {	
	
	private static final WebDriver driver;
	private static final WebDriverWait wait;
	
	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	/**
	 * M�todo para verificar a visibilidade de um elemento utilizando o locator
	 * @param locator
	 */
	public static void isVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * M�todo para verificar a visibilidade de um elemento utilizando o ID
	 * @param id
	 */
	public static void isVisible(String id) {
		isVisible(By.id(id));
	}
	
	/**
	 * M�todo para verificar a presen�a de um elemento utilizando o locator
	 * @param locator
	 */
	public static void isLocated(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * M�todo para verificar a presen�a de um elemento utilizando o ID
	 * @param id
	 */
	public static void isLocated(String id) {
		isLocated(By.id(id));
	}
	
	/**
	 * M�todo para verificar se um elemento � clic�vel utilizando o locator
	 * @param locator
	 */
	public static void isClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
	 * M�todo para verificar se um elemento � clic�vel utilizando o ID
	 * @param id
	 */
	public static void isClickable(String id) {
		isClickable(By.id(id));
	}
	
	
	/**
	 * M�todo para capturar screenshot
	 * @param fileName - Nome do arquivo
	 */
	public static void takeScreenshot(String fileName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date data = new Date();
	    try {
			FileUtils.copyFile(scrFile, new File("D:\\SeleniumScreenShots\\"+fileName+ data.getTime()+".jpeg"),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Pause for X milliseconds.
	 * 
	 * @param iTimeInMillis
	 */
	@Deprecated
	public static void wait(final int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
