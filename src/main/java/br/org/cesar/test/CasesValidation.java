package br.org.cesar.test;

import org.junit.Before;
import org.junit.Test;

import br.org.cesar.common.CasesPage;



public class CasesValidation extends BaseTestcase{
	/**
	 * Example app is CESAR's website
	 * Tests for operations related with the CASES menu screen, like:
	 * Selecting and viewing cases
	 */



	@Before
	public void clickMenu(){
		CasesPage.clickCasesMenu();
	}


	/**
	 *  Select Agronegócios and list all its cases 
	 */
	@Test
	public void selectAgronegociosCase() {
		CasesPage.selectACase(":: Agronegócios");
		CasesPage.assertFirstCaseDisplayed("Monitor de Irrigação");

	}
	
	
	/**
	 *  Open Monitor de Irrigação case from Agronegócios
	 */
	@Test
	public void openMonitorDeIrrigacaoCase() {
		CasesPage.selectACase(":: Agronegócios");
		CasesPage.viewCaseDetails("Monitor de Irrigacao");
		CasesPage.assertCaseDetails("Monitoramento de Irrigação");
	}


}
