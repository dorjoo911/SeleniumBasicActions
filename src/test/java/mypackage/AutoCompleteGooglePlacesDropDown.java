package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteGooglePlacesDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.twoplugs.com/");

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement searchbox = driver.findElement(By.id("autocomplete"));
        searchbox.clear();
        searchbox.click();
        searchbox.sendKeys("Toronto");
        Thread.sleep(3000);
        String text;

        do {
            searchbox.sendKeys(Keys.ARROW_DOWN);
            text = searchbox.getAttribute("value");
            if (text.equals("Toronto, OH, USA")) {
                searchbox.sendKeys(Keys.ENTER);
                break;
            }
            Thread.sleep(3000);

        } while (!text.isEmpty());

        driver.quit();
    }
}
