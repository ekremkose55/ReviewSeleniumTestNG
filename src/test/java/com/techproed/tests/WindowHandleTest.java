package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("PARENT WINDOW HANDLE: " + parentWindowHandle);
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String childWindowHandle : allWindowsHandles) {
            if(!childWindowHandle.equals(parentWindowHandle)){
                driver.switchTo().window(childWindowHandle);
                System.out.println("CHILD WINDOW HANDLE: " + childWindowHandle);
            }
        }
        driver.switchTo().window(parentWindowHandle);
    }
}
