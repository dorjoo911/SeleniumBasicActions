package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropImages {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        WebElement img1 = driver.findElement(By.xpath("//li[1]"));
        WebElement img2 = driver.findElement(By.xpath("//li[2]"));

        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));

        Actions act = new Actions(driver);

        // Moved both items into the trash
        act.dragAndDrop(img1, trash).perform(); // Drag and Drop perform
        act.dragAndDrop(img2, trash).perform();

    }
}
