package br.com.automacao.tests;

import br.com.automacao.pages.IframePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IframeTest extends BaseTest {

    @Test
    public void testEscreverNoIframe() {
        IframePage page = new IframePage(driver);
        
        page.visitar();
        
        // A mágica do entra-e-sai do frame acontece lá dentro
        page.escreverNoEditor("Selenium Java é Top!");
        
        // Valida se conseguimos voltar para a página principal
        String titulo = page.getTituloPagina();
        Assertions.assertEquals("An iFrame containing the TinyMCE WYSIWYG Editor", titulo);
    }
}