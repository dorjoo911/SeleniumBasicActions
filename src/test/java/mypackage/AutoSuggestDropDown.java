package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bing.com/");
        driver.findElement(By.id("sb_form_q")).click();
        driver.findElement(By.id("sb_form_q")).sendKeys("Selenium");

        List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
        System.out.println("Size of Auto suggestions: " + list.size());

        for (WebElement listitem : list) {
            if (listitem.getText().contains("download")) {
                listitem.click();
                break;
            }
        }

        driver.quit();
    }
}
