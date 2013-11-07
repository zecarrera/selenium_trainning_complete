package br.org.cesar.common;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cesar.util.Utils;



/**
 * Página que representa os serviços disponíveis no sub-menu sobre o CESAR
 * @author jcan
 *
 */
public class SobreOCESARPage {

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
	static By sobreOCesarMenuLocator = By.linkText("SOBRE O C.E.S.A.R");
	static By organizacaoMenuLocator = By.linkText("Organização");
	static By processoInovacaoMenuLocator = By.linkText("Processo de Inovação");
	static By pessoasMenuLocator = By.linkText("Pessoas");
	static By organogramaMenuLocator = By.linkText("Organograma");
	static By instalacoesMenuLocator = By.linkText("Instalações");
	static By redeParceriasMenuLocator = By.linkText("Rede de Parcerias");
	static By mantenedoresMenuLocator = By.linkText("Mantenedores");
	static By cesarPARMenuLocator = By.linkText("C.E.S.A.R PAR");
	static By reconhecimentosMenuLocator = By.linkText("Reconhecimentos");
	static By pageSubTitleLocator = By.cssSelector("h2");
	
	public SobreOCESARPage() {
	}

	/**
	 * Clicar no menu Sobre o CESAR
	 */
	public static void clickSobreOCESARMenu(){
		driver.findElement(sobreOCesarMenuLocator).click();
	}	
	
	/**
	 * Clicar no sub-menu Organização
	 */
	public static void clickOrganizacaoSubMenu() { 
		Utils.isVisible(organizacaoMenuLocator);
		driver.findElement(organizacaoMenuLocator).click(); 
	}

	
	/**
	 * Clicar Processo de Inovacao Sub-menu
	 */
	public static void clickProcessoInovacaoSubMenu() { 
		Utils.isVisible(processoInovacaoMenuLocator);
		driver.findElement(processoInovacaoMenuLocator).click(); 
	}
	
	/**
	 * Clicar Pessoas Sub-menu
	 */
	public static void clickPessoasSubMenu() { 
		Utils.isVisible(pessoasMenuLocator);
		driver.findElement(pessoasMenuLocator).click(); 
	}

	/**
	 * Clicks Organograma Sub-menu item
	 */
	public static void clickOrganogramaSubMenu() {
		Utils.isVisible(organogramaMenuLocator);
		driver.findElement(organogramaMenuLocator).click();		
	}
	
	/**
	 * Clicks Instalações Sub-menu item
	 */
	public static void clickInstalacoesSubMenu() {
		Utils.isVisible(instalacoesMenuLocator);
		driver.findElement(instalacoesMenuLocator).click();		
	}
	
	/**
	 * Clicks Rede de Parcerias Sub-menu item
	 */
	public static void clickRedeDeParceriasSubMenu() {
		Utils.isVisible(redeParceriasMenuLocator);
		driver.findElement(redeParceriasMenuLocator).click();		
	}

	/**
	 * Clicks Mantenedores Sub-menu item
	 */
	public static void clickMantenedoresSubMenu() {
		Utils.isVisible(mantenedoresMenuLocator);
		driver.findElement(mantenedoresMenuLocator).click();		
	}

	/**
	 * Clicks C.E.S.A.R PAR Sub-menu item
	 */
	public static void clickCESARPARSubMenu() {
		Utils.isVisible(cesarPARMenuLocator);
		driver.findElement(cesarPARMenuLocator).click();		
	}

	/**
	 * Clicks Reconhecimentos Sub-menu item
	 */
	public static void clickReconhecimentosSubMenu() {
		Utils.isVisible(reconhecimentosMenuLocator);
		driver.findElement(reconhecimentosMenuLocator).click();		
	}
	
	/**
	 * Checa se o sub-titulo da página é o esperado
	 * @param texto
	 */
	public static void assertSubTitle(String texto){
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageSubTitleLocator));
		Assert.assertEquals(texto, driver.findElement(pageSubTitleLocator).getText());
	}


}