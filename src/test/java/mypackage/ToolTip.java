package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/tooltip/");

        // How to get toolTipText value?
        driver.switchTo().frame(0);
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='age']"));
        String toolTipText = inputBox.getAttribute("title");
        System.out.println(toolTipText);

    }
}
