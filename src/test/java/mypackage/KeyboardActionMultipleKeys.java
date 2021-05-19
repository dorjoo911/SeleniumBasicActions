package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionMultipleKeys {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://text-compare.com/");

        WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

        input1.sendKeys("Copy the text using CTRL+V keys");

        Actions act = new Actions(driver);

        // CTRL+A
        act.keyDown(Keys.CONTROL);  // CTRL button press & hold
        act.sendKeys("a");          // press/send A button
        act.keyUp(Keys.CONTROL);    // CTRL button release
        act.perform();              // perform the actions!

        // CTRL+C
        act.keyDown(Keys.CONTROL);  // CTRL button press & hold
        act.sendKeys("c");          // press/send C button
        act.keyUp(Keys.CONTROL);    // CTRL button release
        act.perform();

        // Tab key - shift to input2 box
        act.sendKeys(Keys.TAB);
        act.perform();

        // CTRL+V
        act.keyDown(Keys.CONTROL);  // CTRL button press & hold
        act.sendKeys("v");          // press/send C button
        act.keyUp(Keys.CONTROL);    // CTRL button release
        act.perform();

        // Compare text
        if (input1.getAttribute("value")
                .equals(input2.getAttribute("value"))) {
                    System.out.println(input2.getAttribute("value") + ": Text copied");
                } else {
            System.out.println(input2.getAttribute("value") + ": Text not copied");
        }


    }
}
