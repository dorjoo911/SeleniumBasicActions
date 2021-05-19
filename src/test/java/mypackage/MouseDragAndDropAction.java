package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropAction {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement rome = driver.findElement(By.id("box6"));
        WebElement italy = driver.findElement(By.id("box106"));

        WebElement dc = driver.findElement(By.id("box3"));
        WebElement usa = driver.findElement(By.id("box103"));

        Actions act = new Actions(driver);
        act.dragAndDrop(rome, italy).perform(); // Drag and Drop perform
        act.dragAndDrop(dc, usa).perform();     // Drag and Drop perform

    }

}
