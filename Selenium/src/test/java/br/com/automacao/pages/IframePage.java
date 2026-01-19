package br.com.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePage {

    // O ID do iFrame em si (a moldura)
    private String idDoIframe = "mce_0_ifr";
    
    // O corpo do texto DENTRO do iFrame (note que é um 'body' comum)
    private By corpoDoTexto = By.id("tinymce");
    
    // Um elemento FORA do iFrame (o título da página) para provar que saímos
    private By tituloDaPagina = By.cssSelector("h3");

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public void visitar() {
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    public void escreverNoEditor(String texto) {
        // 1. Entra no iFrame (Muda o foco)
        driver.switchTo().frame(idDoIframe);
        
        // 2. Agora o Selenium enxerga o 'body' do editor
        // Vamos limpar o texto que já vem escrito lá
        driver.findElement(corpoDoTexto).clear();
        
        // 3. Escreve o nosso texto
        type(corpoDoTexto, texto);
        
        // 4. IMPORTANTE: Sai do iFrame e volta para a página principal
        driver.switchTo().defaultContent();
    }

    public String getTituloPagina() {
        // Só funciona se tivermos executado o passo 4 acima!
        return getText(tituloDaPagina);
    }
}