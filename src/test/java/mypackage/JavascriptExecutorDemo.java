package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavascriptExecutorDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // WebDriver is Interface and JavascriptExecutor is too that's why need casting this
//        JavascriptExecutor js = (JavascriptExecutor) driver; //Syntax
//        js.executeScript(Script, args);  //Syntax

        driver.get("https://demo.nopcommerce.com/");

        //Flash
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavascriptUtil.flashElement(logo,driver);

        //Drawing border & take screenshot
//        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//        JavascriptUtil.drawBorder(logo, driver);
//
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        File trg = new File("src/test/screenshots/logoHighlighted.png");
//        FileUtils.copyFile(src, trg);

        //Getting title of the page
//        String title = JavascriptUtil.getTitleByJS(driver);
//        System.out.println(title);

        //Click action
//        WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
//        JavascriptUtil.clickElementByJS(regLink, driver);

        //Generate alert
//        JavascriptUtil.generateAlert(driver, "This is my Alert!");

        //Refreshing the page
//        JavascriptUtil.refreshBrowserByJS(driver);

        //Scroll Down & Up the page
//        JavascriptUtil.scrollPageDown(driver);
//        Thread.sleep(2000);
//        JavascriptUtil.scrollPageUp(driver);

        //Zoom page
//        JavascriptUtil.zoomPageByJS(driver);

    }
}
