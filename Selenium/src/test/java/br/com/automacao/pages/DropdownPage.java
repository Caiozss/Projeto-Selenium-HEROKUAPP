package br.com.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private By dropdown = By.id("dropdown");
    private By option1 = By.xpath("//option[@value='1']");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void visitar() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selecionarOpcaoPorTexto(String opcao) {
        // achar o elemento
        var elementoDropdown = driver.findElement(dropdown);

        Select select = new Select(elementoDropdown);
        
        select.selectByVisibleText(opcao);
    }

    public String obterOpcaoSelecionada() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }    
}
