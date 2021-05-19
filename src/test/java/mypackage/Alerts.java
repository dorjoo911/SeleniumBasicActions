package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        //Alert window with OK button.
//        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//        Thread.sleep(3000);
//        driver.switchTo().alert().accept();

        //Alert window with OK and Cancel buttons
//        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//        Thread.sleep(3000);
////        driver.switchTo().alert().accept(); // Close alert by using OK button.
//        driver.switchTo().alert().dismiss(); // Close alert by using Cancel button.

        //Alert window with INPUT button
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);

        Alert alertWindow = driver.switchTo().alert();
        System.out.println("The message displayed on alert: " + alertWindow.getText());

        alertWindow.sendKeys("Welcome");
        alertWindow.accept();




    }
}
