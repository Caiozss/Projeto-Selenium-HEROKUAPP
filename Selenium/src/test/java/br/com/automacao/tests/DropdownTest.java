package br.com.automacao.tests;

import br.com.automacao.pages.DropdownPage;
import br.com.automacao.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DropdownTest extends BaseTest {
    
    @Test
    public void testSelecionarOpcaoDropdown() {
        // Instancia a página de dropdown
        DropdownPage dropdownPage = new DropdownPage(driver);

        // Acessa a página de dropdown
        dropdownPage.visitar();

        // Seleciona a opção "Option 1"
        dropdownPage.selecionarOpcaoPorTexto("Option 1");

        
        // Tira uma foto da tela após a seleção
        Utils.tirarPrint(driver, "Dropdown_Option_1_Selected");
    }
}
