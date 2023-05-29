package tests;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class VerificarGuiasNegadasHMSLTest {
    @Test

    public void testFazerLogin() throws InterruptedException {

        System.setProperty("chromedriver", "C:\\chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        wait(5000);

        //variaveis
        String url = "http://sitedeteste.com.br";
        String user = "";
        String password = "";
        String cardNumber = "99999999977411"; //negado

        //login
        navegador.get(url);
        navegador.findElement(By.cssSelector("#UserName")).sendKeys(user);
        navegador.findElement(By.cssSelector("#Password")).sendKeys(password);
        navegador.findElement(By.cssSelector("#btnEntrar")).click();
        wait(5000);

        //localização de guias

        navegador.findElement(By.cssSelector("#navbar-unimed > ul:nth-child(1) > li:nth-child(5) > a")).click();
        navegador.findElement(By.cssSelector("#navbar-unimed > ul:nth-child(1) > li.dropdown.open > ul > li:nth-child(4) > a")).click();
        Thread.sleep(5000);
        navegador.findElement(By.cssSelector("#BeneficiarioAutocomplete")).sendKeys(cardNumber);
        Thread.sleep(5000);
        navegador.findElement(By.cssSelector("#BeneficiarioAutocomplete")).click();
        navegador.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        navegador.findElement(By.cssSelector("#BeneficiarioAutocomplete")).sendKeys(Keys.DOWN);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.findElement(By.cssSelector("#BeneficiarioAutocomplete")).sendKeys(Keys.ENTER);
        navegador.findElement(By.cssSelector("#btnListar")).click();
        Thread.sleep(5000);
        navegador.findElement(By.cssSelector("#tabela-atendimentos > tbody > tr.odd > td.text-center.hidden-xs\\\" > i.fa.fa-file-text-o.fa-lg.acao.elemento-tooltip")).click();
        Thread.sleep(5000);
        String texto = navegador.findElement((By.cssSelector(".cabecalho-guia"))).getText();
        Thread.sleep(5000);

        List<WebElement> lista = navegador.findElements(By.cssSelector("#tabela-atendimentos > tbody > tr"));
        for (int i = 0; i < lista.size(); i++) {


            if (texto.contains("NEGADO")) {

                TakesScreenshot screenshot = (TakesScreenshot) navegador;
                File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
                File destinationfile = new File("C:\\Print_sulMineira\\imagem.jpg");
                try {
                    FileHandler.copy(sourcefile, destinationfile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }


        }
    }
}