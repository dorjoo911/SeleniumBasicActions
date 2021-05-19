package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVsActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        WebElement features = driver.findElement(By.xpath("//a[@title='Women']"));

        Actions act = new Actions(driver); // Actions is Class
//        act.moveToElement(features).perform(); // internally calling .build().perform() method
//        act.moveToElement(features).build().perform(); // directly calling .build().perform() method using build() method twice

        // Action is Interface.
        // this case: existing action saving to different Action interface variable
        // then perform() this action.
        Action action = act.moveToElement(features).build();
        action.perform();
    }
}
