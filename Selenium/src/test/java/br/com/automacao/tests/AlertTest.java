package br.com.automacao.tests;

import br.com.automacao.pages.AlertPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlertTest extends BaseTest {

    @Test
    public void testLidarComAlerta() {
        AlertPage page = new AlertPage(driver);

        page.visitar();
        page.dispararAlerta();
        
        // Se você não aceitar o alerta, o teste falha na próxima linha!
        page.aceitarAlerta();

        String texto = page.obterResultado();
        Assertions.assertEquals("You successfully clicked an alert", texto);
    }
}