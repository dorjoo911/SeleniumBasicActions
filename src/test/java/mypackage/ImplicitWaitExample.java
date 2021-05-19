package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.golomtbank.com/");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[1]/header/div[1]/div/nav/div[2]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"gsc-i-id1\"]")).sendKeys("hadgalamj");
        driver.findElement(By.xpath("//*[@id=\"gsc-i-id1\"]")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a")).click();

        //Explicit wait


    }
}
