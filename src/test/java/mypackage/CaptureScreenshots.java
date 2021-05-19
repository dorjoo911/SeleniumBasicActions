package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
// WebDriver driver = new ChromeDriver();--> for: TakesScreenshot ts = (TakesScreenshot)driver;
        ChromeDriver driver = new ChromeDriver();// --> for: TakesScreenshot ts = driver;

        driver.get("https://demo.nopcommerce.com/");
        //Full page screenshot
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        // driver.ChromeDriver.ChromiumDriver.RemoteWebDriver.WebDriver *tree
//        // so ...TakesScreenshot interface need casting
//        TakesScreenshot ts = driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        File trg = new File("src/test/screenshots/homepage.png");
//
//        FileUtils.copyFile(src, trg);

//        //Screenshot of section/portion of the page
//        WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
//
//        File src = section.getScreenshotAs(OutputType.FILE);
//        File trg = new File("src/test/screenshots/featuredProducts.png");
//        FileUtils.copyFile(src, trg);

        //Screenshot of section/portion of the page
        WebElement ele = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

        File src = ele.getScreenshotAs(OutputType.FILE);
        File trg = new File("src/test/screenshots/logo.png");
        FileUtils.copyFile(src, trg);

        driver.quit();

    }
}
