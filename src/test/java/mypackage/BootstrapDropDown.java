package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hdfcbank.com/");

        driver.findElement(By.xpath
                ("//*[@id=\"main\"]/div[2]/div[13]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/a"))
                .click();

        List<WebElement> productType = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));

        System.out.println("Number of options: " + productType.size());

        for (WebElement proType:productType) {
            if (proType.getText().equals("Accounts")){
                proType.click();
                break;
            }

        }


    }
}
