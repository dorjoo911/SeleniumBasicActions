package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
    public static void main(String[] args) {

        //Chrome Browser
//        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver(); //ChromeDriver driver = new ChromeDriver();

        //FireFox Browser
//        System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver(); //FirefoxDriver driver = new FirefoxDriver();

        //Edge Browser
//        System.setProperty("webdriver.edge.driver", "D:\\Drivers\\msedgedriver.exe");
//        WebDriver driver = new EdgeDriver(); //EdgeDriver driver = new EdgeDriver();

        //*** using WebDriverManager ***////
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver();

        driver.get("https://google.com/");
        System.out.println("Title of the web-page is: " + driver.getTitle());
        System.out.println("Current URL of the web-page is: " + driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
