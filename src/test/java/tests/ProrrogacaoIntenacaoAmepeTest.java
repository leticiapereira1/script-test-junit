package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Instant;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class ProrrogacaoIntenacaoAmepeTest {

    private Instant wait;

    @Test

    public void prorrogacaoInternacao() throws InterruptedException {

        System.setProperty("chromedriver", "C:\\Windows");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        wait(500);

        Actions actions = new Actions(navegador);


        //variaveis
        String url = "www.sitedeteste.com.br";
        String user = "";
        String password = "";
        String beneficiarioNumber = "9999999999999999";
        String conselhoNumber = "10128";
        String outrasTerapias = "03 - Outras Terapias";
        String codigoProrrogacao = "99999999";
        String quantDiarias = "1";
        String observacaoProrrogacao = "Teste de envio de prorrogação de internação.";


        //login
        navegador.get(url);
        navegador.findElement(By.cssSelector("#operador")).sendKeys(user);
        navegador.findElement(By.cssSelector("#senha")).sendKeys(password);
        navegador.findElement(By.cssSelector("#entrar")).click();
        navegador.findElement(By.xpath("/html/body/b/div[2]/div/div[3]/button")).click();// fechar popup
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //preenchimento formulário
        navegador.findElement(By.cssSelector("#menu_nav > div > div.container > div.span15 > div > ul > li:nth-child(3) > a")).click();
        navegador.findElement(By.cssSelector("#menu_nav > div > div.container > div.span15 > div > ul > li.dropdown.open > ul > li:nth-child(2) > a")).click();
        Thread.sleep(500);
        navegador.findElement(By.cssSelector("#codigo")).sendKeys(beneficiarioNumber);
        navegador.findElement(By.cssSelector("#busca_usuario")).click();
        navegador.findElement(By.cssSelector("#busca_solicitante")).click();
        Thread.sleep(500);

        //novapopup

        String originalWindow = navegador.getWindowHandle();
        Set<String> allWindows = navegador.getWindowHandles();

        for (String chilWin : allWindows) {
            if (allWindows.add(chilWin)) {
                navegador.switchTo().window(chilWin);
            } else {
                navegador.switchTo().window(chilWin);
            }

        }

        navegador.findElement(By.cssSelector("#mostraFiltros")).click();
        navegador.findElement(By.cssSelector("#conselho")).sendKeys(conselhoNumber);
        navegador.findElement(By.cssSelector("#localizar")).click();
        navegador.findElement(By.cssSelector("#\\34 7868 > td:nth-child(2)")).click();


        navegador.switchTo().window(originalWindow);

        //preenchendo formulario 'dados da guia'


        Thread.sleep(500);
        navegador.findElement(By.cssSelector("#executante")).click();
        Thread.sleep(500);
        navegador.findElement(By.cssSelector("#executante")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        navegador.findElement(By.cssSelector("#executante")).sendKeys(Keys.ENTER);

        navegador.findElement(By.cssSelector("#especialidadeSolicitante")).click();
        navegador.findElement(By.cssSelector("#especialidadeSolicitante")).sendKeys(Keys.ARROW_DOWN);
        navegador.findElement(By.cssSelector("#especialidadeSolicitante")).sendKeys(Keys.ENTER);

        navegador.findElement(By.cssSelector("#tipo_atendimento")).click();
        navegador.findElement(By.cssSelector("#tipo_atendimento")).sendKeys(outrasTerapias);


        //preenchendo formulario 'taxas/diárias'


        JavascriptExecutor jse = (JavascriptExecutor) navegador;
        jse.executeScript("window.scrollBy(0,120)");//scrol down

        navegador.findElement(By.cssSelector("#accordion2 > div:nth-child(3) > div.accordion-heading > a")).click();
        navegador.findElement(By.cssSelector("#botao_taxa0")).click();

        //popup
        String originalWindow1 = navegador.getWindowHandle();
        Set<String> allWindows1 = navegador.getWindowHandles();

        for (String chilWin1 : allWindows1) {
            if (allWindows1.add(chilWin1)) {
                navegador.switchTo().window(chilWin1);
            } else {
                navegador.switchTo().window(chilWin1);
            }

        }
        navegador.findElement(By.cssSelector("#nome")).sendKeys("PRORROGAÇÃO");
        navegador.findElement(By.cssSelector("#codigo")).sendKeys(codigoProrrogacao);
        navegador.findElement(By.cssSelector("#localizar")).click();
        navegador.findElement(By.cssSelector("#\\31 1000143 > td:nth-child(2)")).click();

        navegador.switchTo().window(originalWindow1);

        //Prencher quantidade de diarias no fomularios 'taxas e diarias'

        navegador.findElement(By.cssSelector("#qtde_taxa0")).clear();
        navegador.findElement(By.cssSelector("#qtde_taxa0")).sendKeys(quantDiarias);

        //anexos
        navegador.findElement(By.cssSelector("#form1 > div:nth-child(20) > div.accordion-heading > a")).click();
        navegador.switchTo().parentFrame();
        navegador.switchTo().frame(navegador.findElement(By.cssSelector("#upload0")));


        navegador.findElement(By.name("upload0")).click();
        //ver como poderá localizar um arquivo


        //"Observação impressa/ Justificativa da guia"

        navegador.findElement(By.cssSelector("#form1 > div:nth-child(21) > div.accordion-heading > a")).click();
        navegador.findElement(By.cssSelector("#observacao_guia")).sendKeys(observacaoProrrogacao);

        navegador.findElement(By.cssSelector("#autorizar")).click();


    }


}

