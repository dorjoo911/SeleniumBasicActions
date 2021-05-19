package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTextVsgetAttributeValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2F");
        WebElement emailinputbox = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
//        emailinputbox.clear();
//        emailinputbox.sendKeys("newAdmin@gmail.com");

        //capturing text from inputbox
        System.out.println("Result from getAttribute() method: " + emailinputbox.getAttribute("name"));
        //return value of attribute's value as a text.
        System.out.println("Result from getText() method: " + emailinputbox.getText()); //return inner text only.

        //getText() --> Login button's link text
        WebElement loginButtonText = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
        System.out.println("Login button's inner text is: " + loginButtonText.getText());

    }
}
