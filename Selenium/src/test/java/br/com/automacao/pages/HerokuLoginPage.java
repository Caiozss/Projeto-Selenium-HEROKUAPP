package br.com.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HerokuLoginPage extends BasePage {


        //1. Locators (IDs e CSS do HerokuApp)
        private By usernameField = By.id("username");
        private By passwordField = By.id("password");
        private By LoginButton = By.cssSelector("button.radius"); //Botão Login
        private By flashMessage = By.id("flash"); //A barra verde/vermelha de aviso
    
        //2. Construtor 
        public HerokuLoginPage(WebDriver driver) {
            super(driver);
        }

        //3. As Ações
        public void visitar() {
            driver.get("https://the-internet.herokuapp.com/login");
        }

        public void logar(String usuario, String senha) {
            type(usernameField, usuario);
            type(passwordField, senha);
            click(LoginButton);
        }

        public String getMensagemAlerta() {
            return getText(flashMessage);
        }
}
