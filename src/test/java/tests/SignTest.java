package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignTest {
    @Test

    public void testFazerLoginNoTaskit (){
        System.setProperty("chromedriver", "C:\\chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get("http://www.juliodelima.com.br/taskit/");

        navegador.findElement(By.linkText("Sign in")).click();

        navegador.findElement(By.id("signinbox")).findElement(By.cssSelector("#login-sign-in")).sendKeys("julio0001");
        navegador.findElement(By.id("signinbox")).findElement(By.cssSelector("#password-sign-in")).sendKeys("123456");

        navegador.findElement(By.linkText("SIGN IN")).click();

        String saudacao = navegador.findElement(By.className("me")).getText();

        Assert.assertEquals("Hi, Julio",saudacao);

        navegador.quit();



    }
}
