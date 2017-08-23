package com.qaworks.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

import static com.qaworks.steps.WebTestBase.driver;

public class WebCommonAction {

    public boolean isElementDisplay(WebElement display_ele) {
        try {
            Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            wait1.until(ExpectedConditions.visibilityOf(display_ele));

            if (display_ele.isDisplayed())
                return true;
            else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean waitForAlertAndAcceptAlert(WebDriver driver,int time) throws InterruptedException {
        int i=0;
        while(i++<time)
        {
            try
            {
                Alert alert = driver.switchTo().alert();
                alert.accept();
                driver.switchTo().defaultContent();
                return true;
            }
            catch(NoAlertPresentException e)
            {
                Thread.sleep(1000);
                continue;
            }
        }
        return false;
    }
}
