package br.com.automacao.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {
    
    private By botaoAlertaSimples = By.xpath("//button[text()='Click for JS Alert']");
    private By resultado = By.id("result");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void visitar() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void dispararAlerta() {
        click(botaoAlertaSimples);
    }
    public void aceitarAlerta() {
        Alert alerta = driver.switchTo().alert();
        alerta.accept();
    }
    public String obterResultado() {
        return getText(resultado);
    }
}