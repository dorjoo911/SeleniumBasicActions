package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
//        driver.switchTo().frame(name of the frame/id of the frame);
//        driver.switchTo().frame(WebElement);
//        driver.switchTo().frame(0);

        //First frame
        driver.switchTo().frame("packageListFrame"); // name of the frame
        driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
        driver.switchTo().defaultContent(); // go back to the main page

        //Second frame
        Thread.sleep(2000);
        driver.switchTo().frame("packageFrame"); //second frame name
        driver.findElement(By.xpath("//span[text()='WebDriver']")).click();
        driver.switchTo().defaultContent(); // go back to the main page

        //Third frame
        Thread.sleep(2000);
        driver.switchTo().frame("classFrame"); //third frame name
        driver.findElement(By.xpath("//a[text()='Help']")).click();

        driver.quit();


    }
}
