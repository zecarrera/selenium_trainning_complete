package br.org.cesar.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.org.cesar.common.UnidadesPage;



public class UnidadesValidation extends BaseTestcase{
	/**
	 * Example app is CESAR's website
	 * Tests for operations related with the UNIDADES menu screen, like:
	 * Navigation on subMenus and Share by e-mail action
	 */



	@Before
	public void clickMenu(){
		UnidadesPage.clickSUnidadesMenu();
	}


	/**
	 *  Open C.E.S.A.R São Paulo sub-item and check its content 
	 */
	@Test
	public void openUnidadeSPSubItem() {
		UnidadesPage.clickSubMenu("C.E.S.A.R São Paulo");
		UnidadesPage.assertSubTitle("C.E.S.A.R São Paulo");
	}
	
	/**
	 *  Open C.E.S.A.R Sorocaba sub-item and check its content 
	 */
	@Test
	public void openUnidadeSorocabaSubItem() {
		UnidadesPage.clickSubMenu("C.E.S.A.R Sorocaba");
		UnidadesPage.assertSubTitle("C.E.S.A.R Sorocaba");
	}
	
	/**
	 *  Open C.E.S.A.R Sul sub-item and check its content 
	 */
	@Test
	public void openUnidadeSulSubItem() {
		UnidadesPage.clickSubMenu("C.E.S.A.R Sul");
		UnidadesPage.assertSubTitle("C.E.S.A.R Sul");
	}
	
	
	/**
	 *  Assert if twitter button is present
	 */
	@Test
	public void assertPresenceOfTwitterButton() {
		UnidadesPage.clickSubMenu("C.E.S.A.R São Paulo");
		UnidadesPage.assertSubTitle("C.E.S.A.R São Paulo");
		UnidadesPage.clickEmailIcon();
		UnidadesPage.assertButtonPresent(By.cssSelector("img[alt='Twitter']"));
	}
	
	/**
	 *  Share unity by email 
	 */
	@Test
	public void shareUnidadeSPbyEmail() {
		UnidadesPage.clickSubMenu("C.E.S.A.R São Paulo");
		UnidadesPage.assertSubTitle("C.E.S.A.R São Paulo");
		UnidadesPage.clickEmailIcon();
		UnidadesPage.fillOutEmailForm("jcan@cesar.org.br", "jcan@cesar.org.br", "mensagem");
		UnidadesPage.confirmEmailShareButton(true);
		UnidadesPage.assertEmailsuccessfullySent();
	}
	
	/**
	 *  Cancel share unity by email 
	 */
	@Test
	public void cancelShareUnidadeSPbyEmail() {
		UnidadesPage.clickSubMenu("C.E.S.A.R São Paulo");
		UnidadesPage.assertSubTitle("C.E.S.A.R São Paulo");
		UnidadesPage.clickEmailIcon();
		UnidadesPage.fillOutEmailForm("jcan@cesar.org.br", "jcan@cesar.org.br", "mensagem");
		UnidadesPage.confirmEmailShareButton(false);
		UnidadesPage.assertEmailnotSent();
	}
}
