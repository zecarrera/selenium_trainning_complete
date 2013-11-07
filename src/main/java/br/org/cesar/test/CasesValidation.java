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
	 *  Select Agroneg�cios and list all its cases 
	 */
	@Test
	public void selectAgronegociosCase() {
		CasesPage.selectACase(":: Agroneg�cios");
		CasesPage.assertFirstCaseDisplayed("Monitor de Irriga��o");

	}
	
	
	/**
	 *  Open Monitor de Irriga��o case from Agroneg�cios
	 */
	@Test
	public void openMonitorDeIrrigacaoCase() {
		CasesPage.selectACase(":: Agroneg�cios");
		CasesPage.viewCaseDetails("Monitor de Irrigacao");
		CasesPage.assertCaseDetails("Monitoramento de Irriga��o");
	}


}
