package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {


    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlerst = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlerst.click();
        Thread.sleep(3000);

        System.out.println("ALERT MESAJI: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement result1 = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println("ALERT RESULT: " +result1.getText());

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        Thread.sleep(3000);

        System.out.println("CONFIRM MESAJI: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        //driver.switchTo().alert().accept();
        WebElement result2 = driver.findElement(By.id("result"));
        System.out.println("CONFIRM RESULT: " +result2.getText());

        WebElement jsPromt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromt.click();
        Thread.sleep(3000);

        System.out.println("PROMT MESAJI: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Ekrem Kose");
        driver.switchTo().alert().accept();
        WebElement result3 = driver.findElement(By.id("result"));
        System.out.println("PROMT RESULT: " +result3.getText());

    }
}
