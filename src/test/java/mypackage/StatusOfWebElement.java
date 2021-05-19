package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusOfWebElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //isDisplayed() isEnabled() ==>

        WebElement searchStore = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        System.out.println("Display status: " + searchStore.isDisplayed()); //true
        System.out.println("Display status: " + searchStore.isEnabled()); //true

        //isSelected() ==> radio button, check boxes and dropdown
        WebElement male = driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
        WebElement female = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));

        System.out.println("Is male button selected? ==> " + male.isSelected()); //false
        System.out.println("Is female button selected? ==> " + female.isSelected()); //false

        male.click(); //selects male radio button
        System.out.println("Is male button selected? ==> " + male.isSelected()); //true
        System.out.println("Is female button selected? ==> " + female.isSelected()); //false

        female.click(); //select female button
        System.out.println("Is male button selected? ==> " + male.isSelected()); //false
        System.out.println("Is female button selected? ==> " + female.isSelected()); //true

        driver.quit();

    }
}
