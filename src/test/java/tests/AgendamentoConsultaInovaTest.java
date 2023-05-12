package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AgendamentoConsultaInovaTest {

@Test
    public void testAgendamentoConsultaCross () throws InterruptedException {

        System.setProperty("chromedriver", "C:\\chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //variaveis
        String url = "www.sitedeteste.com.br";
        String user = "";
        String password = "";


        //login
        navegador.get(url);
        Thread.sleep(500);

        navegador.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
        Thread.sleep(500);
        navegador.findElement(By.cssSelector("#usuario_0")).click();
        Thread.sleep(500);
        navegador.findElement(By.cssSelector("#usuario_4")).sendKeys(user);
        navegador.findElement(By.cssSelector("#senha_4")).sendKeys(password);

        navegador.findElement(By.cssSelector("#btn_entrar_4")).click();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


}
