package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrameTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe ");
       // driver.switchTo().frame(0); //index ile iframe gecis
       // driver.switchTo().frame("mce_0_ifr");  // id ile iframe gecis
        WebElement iframe = driver.findElement(By.tagName("iframe"));// web element ile iframe locate edilir
        driver.switchTo().frame(iframe); // sonra da path frame() icine yazilarak iframe gecilir
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Ekrem Kose");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        WebElement textMessage =  driver.findElement(By.xpath("//a[@target = '_blank']"));
        textMessage.click();
        System.out.println(textMessage.getText());
    }
}
