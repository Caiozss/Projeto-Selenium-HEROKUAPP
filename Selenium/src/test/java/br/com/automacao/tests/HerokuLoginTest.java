package br.com.automacao.tests;

import br.com.automacao.pages.HerokuLoginPage;
import br.com.automacao.utils.TestData;
import br.com.automacao.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HerokuLoginTest extends BaseTest {
    
    @Test
    public void testLoginComSucessoHeroku(){
        // Carrega dados
        TestData dados = Utils.getMassaDados("MassaDados.json", TestData.class);

        // Instancia página
        HerokuLoginPage herokuLoginPage = new HerokuLoginPage(driver);

        // Acessa a página de login
        herokuLoginPage.visitar();

        // Realiza o login
        herokuLoginPage.logar(dados.herokuUser, dados.herokuPass);

        // Valida o login com sucesso
        String mensagem = herokuLoginPage.getMensagemAlerta();
        Assertions.assertTrue(mensagem.contains("You logged into a secure area!"),
         "Mensagem de login com sucesso não exibida.");

        // Tira uma foto da tela após o login
        Utils.tirarPrint(driver, "Heroku_Login_Sucesso");
    }
}
