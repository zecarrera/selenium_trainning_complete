package br.org.cesar.test;

import org.junit.Test;

import br.org.cesar.common.AreaDeConhecimentoPage;
import br.org.cesar.common.SobreOCESARPage;



public class AreaDeConhecimentoValidation extends BaseTestcase{
	/**
	 * Example app is CESAR's website
	 * Tests for operations related with the area do conhecimento menu, like:
	 * Sub-itens: Testes
	 */



	/**
	 *  Open testes sub-item and check its content 
	 */
	@Test
	public void openTestesSubItem() {
		AreaDeConhecimentoPage.clickAreaDeConhecimentoMenu();
		AreaDeConhecimentoPage.clickTestesSubMenu();
		AreaDeConhecimentoPage.assertSubTitle("Testes");
	}

}
