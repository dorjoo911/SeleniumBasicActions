package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {
    public static void main(String[] args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.monsterindia.com/");

        driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();

        // Using sendKeys() //Only type="file" case it works // Use absolute path
//        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\wetop\\Downloads\\Selenium_Cucumber_BoilerPlate-master\\SeleniumBasics\\src\\test\\Downloads\\file-sample_100kB.doc");

        // Using Robo Class method
        WebElement button = driver.findElement(By.xpath("//input[@id='file-upload']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button); // click action on the button

        /*
            1. Copy the path
            2. CTRL+V
            3. Enter
         */

        Robot rd =new Robot();
        rd.delay(1000);

        //CTRL+C action on copying file location path
        StringSelection ss =new StringSelection("C:\\Users\\wetop\\Downloads\\Selenium_Cucumber_BoilerPlate-master\\SeleniumBasics\\src\\test\\Downloads\\file-sample_100kB.doc");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //CTRL+V action
        rd.keyPress(KeyEvent.VK_CONTROL); // Press on CTRL key
        rd.keyPress(KeyEvent.VK_V); // Press on V key

        rd.keyRelease(KeyEvent.VK_CONTROL); // Release on CTRL key
        rd.keyRelease(KeyEvent.VK_V); // Release on V key

        // Press Enter key
        rd.keyPress(KeyEvent.VK_ENTER); // Press on ENTER key
        rd.keyRelease(KeyEvent.VK_ENTER); // Release on ENTER key

    }
}
