package br.org.cesar.test;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;


import br.org.cesar.common.SobreOCESARImprovedPage;
import br.org.cesar.util.Utils;



public class SobreOCESARImprovedValidation extends BaseTestcase{
	/**
	 * Example app is CESAR's website
	 * Tests for operations related with the sobre o cesar menu, like:
	 * Sub-itens: Organização
	 */
	@Before
	public void clickMenu(){
		SobreOCESARImprovedPage.clickSobreOCESARMenu();
	}


	/**
	 *  Open organização sub-item and check its content 
	 */
	@Test
	public void openOrganizacaoSubItem() throws TimeoutException{
		try{
			clickAndAssert("Organização");
		}catch (TimeoutException e){
			Utils.takeScreenshot(this.getClass().getName());
			Assert.fail(e.getMessage());
		}
	}

	/**
	 *  Open processo de inovacao sub-item and check its content 
	 */
	@Test
	public void openProcessoInovacaoSubItem() {
		clickAndAssert("Processo de Inovação");
	}

	/**
	 *  Open pessoas sub-item and check its content 
	 */
	@Test
	public void openPessoasSubItem() {
		clickAndAssert("Pessoas");
	}

	
	/**
	 *  Open organograma sub-item and check its content 
	 */
	@Test
	public void openOrganogramaSubItem() {
		clickAndAssert("Organograma");
	}
	
	/**
	 *  Open instalações sub-item and check its content 
	 */
	@Test
	public void openInstalacoesSubItem() {
		clickAndAssert("Instalações");
	}
	
	/**
	 *  Open rede de parcerias sub-item and check its content 
	 */
	@Test
	public void openRedeDeParceriasSubItem() {
		clickAndAssert("Rede de Parcerias");
	}
	
	/**
	 *  Open reconhecimentos sub-item and check its content 
	 */
	@Test
	public void openReconhecimentosSubItem() {
		clickAndAssert("Reconhecimentos");
	}
	
	/**
	 *  Open mantenedores sub-item and check its content 
	 */
	@Test
	public void openMantenedoresSubItem() {
		clickAndAssert("Mantenedores");
	}
	
	/**
	 *  Open CESAR Par sub-item and check its content 
	 */
	@Test
	public void openCESARPARSubItem() {
		clickAndAssert("C.E.S.A.R PAR");
	}
	
	/**
	 * Private method created just to simplify created tests
	 * @param menuItem
	 */
	private void clickAndAssert(String menuItem){
		SobreOCESARImprovedPage.clickSubMenu(menuItem);
		SobreOCESARImprovedPage.assertSubTitle(menuItem);
	}
}
