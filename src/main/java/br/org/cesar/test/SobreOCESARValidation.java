package br.org.cesar.test;

import org.junit.Test;

import br.org.cesar.common.SobreOCESARPage;


/**
 * Classes com testes relacionados ao menu Sobre o CESAR
 */
public class SobreOCESARValidation extends BaseTestcase{



	/**
	 *  Open organização sub-item and check its content 
	 */
	@Test
	public void openOrganizacaoSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickOrganizacaoSubMenu();;
		SobreOCESARPage.assertSubTitle("Organização");
	}

	/**
	 *  Open organização sub-item and check its content 
	 */
	@Test
	public void openProcessoInovacaoSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickProcessoInovacaoSubMenu();
		SobreOCESARPage.assertSubTitle("Processo de Inovação");
	}

	/**
	 *  Open organização sub-item and check its content 
	 */
	@Test
	public void openPessoasSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickPessoasSubMenu();
		SobreOCESARPage.assertSubTitle("Pessoas");
	}

	
	/**
	 *  Open organograma sub-item and check its content 
	 */
	@Test
	public void openOrganogramaSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickOrganogramaSubMenu();
		SobreOCESARPage.assertSubTitle("Organograma");
	}
	
	/**
	 *  Open instalações sub-item and check its content 
	 */
	@Test
	public void openInstalacoesSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickInstalacoesSubMenu();
		SobreOCESARPage.assertSubTitle("Instalações");
	}
	
	/**
	 *  Open rede de parcerias sub-item and check its content 
	 */
	@Test
	public void openRedeDeParceriasSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickRedeDeParceriasSubMenu();
		SobreOCESARPage.assertSubTitle("Rede de Parcerias");
	}
	
	/**
	 *  Open reconhecimentos sub-item and check its content 
	 */
	@Test
	public void openReconhecimentosSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickReconhecimentosSubMenu();
		SobreOCESARPage.assertSubTitle("Reconhecimentos");
	}
	
	/**
	 *  Open mantenedores sub-item and check its content 
	 */
	@Test
	public void openMantenedoresSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickMantenedoresSubMenu();
		SobreOCESARPage.assertSubTitle("Mantenedores");
	}
	
	/**
	 *  Open CESAR Par sub-item and check its content 
	 */
	@Test
	public void openCESARPARSubItem() {
		SobreOCESARPage.clickSobreOCESARMenu();
		SobreOCESARPage.clickCESARPARSubMenu();
		SobreOCESARPage.assertSubTitle("C.E.S.A.R PAR");
	}
}
